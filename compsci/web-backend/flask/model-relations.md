# Flask Model Relations

- Model relations are little bit of confusing, not just in flask but in databases general. The tech is not cnofusing at all just the logic behind it. Lets define relationship first and than implement it in flask

### Defining Relationship

- In the real world, however, model classes (database tables) uncommonly exist on their own. Most of the time they are connected with other models through various relationships like one-to-one, one-to-many and many-to-many.

  Let’s expand on the analogy of a blog site. Generally, a blog post belongs to a category and one or more tags. In other words, there is a one-to-many relationship between a category and a post and a many-to-many relationship between a post and a tag.
  
## One-To-Many Relationship
  
-  A one to many relationships is created by placing a foreign key on the child table. This is the most common type of relationship you will encounter while working with databases. To create one to many relationships in SQLAlchemy, we do the following:
  - 1 - Create a new `db.Column` instance using `db.ForeignKey` constraint in the child class.
  - 2 - Define a new property using `db.relationship` directive in the parent class. This property will be used to access related objects.

- Lets implement a One-to-Many realtainship as we have learned above:
  ```py
  # PARENT node
  class Category:
    __tablename__ = 'categories'
    id = db.Column(db.Integer(), primary_key=True)
    name = db.Column(db.String(255), nullable=False)
    ...
    posts = db.relationship('posts')
    
   # One-To-Many Relation
  class Post:
    __tablename__ = 'posts'
    id = db.Column(db.Integer(), primary_key=True)
    text = db.Column(db.String(255), nullable=False)
    ...
    category_id = db.Column(db.Integer(), db.ForeignKey('categories.id'))  #important!
  ```
  The `db.ForeignKey()` accepts the name of the column on which you what to define the foreign key. Here we are passing `categories.id` to the `db.ForeignKey()`, it means that the `category_id` attribute of the `Post` model can only take values from the `id` column of the `categories` table.
  
  Next we have `posts` attribute in the `Category` model defined using `db.relationship()` directive. The `db.relationship()` is used add to bidirectional relationship. In other words, it adds an attribute on the model class to access related objects. At its simplest, it accepts at least one positional argument which is the name of the class on the other side of the relationship.
  
    Now if we have a `Category` object (say `c`) then we can access all posts under it as `c.posts`. What if you want to access the data from the other side of the relationship i.e get category from a post object? This is where `backref` comes into play. So the code:
    ```python
    posts = db.relationship('Post', backref='category')
    ```
    adds a `category` attribute to the `Post` object. That means if we have a `Post` object (say `p`) then we can access its category as `p.category`.
    
    > Note that unlike attribute representing foreign key (which must be defined on the many side of the relationship) you can define db.relationship() on any side of the relationship.
  
<br>

## One-to-One Relationship

- Establishing a one-to-one relationship in SQLAlchemy is almost the same as one-to-many relationship, the only difference is that we pass an additional argument `uselist=False` to the `db.relationship()` directive. Here is an example:
  ```python
  class Employee(db.Model):
      __tablename__ = 'employees'
      id = db.Column(db.Integer(), primary_key=True)
      name = db.Column(db.String(255), nullable=False)
      designation = db.Column(db.String(255), nullable=False)
      doj = db.Column(db.Date(), nullable=False)
      dl = db.relationship('DriverLicense', backref='employee', uselist=False)

  class DriverLicense(db.Model):
      __tablename__ = 'driverlicense'
      id = db.Column(db.Integer(), primary_key=True)
      license_number = db.Column(db.String(255), nullable=False)
      renewed_on = db.Column(db.Date(), nullable=False)
      expiry_date = db.Column(db.Date(), nullable=False)
      employee_id = db.Column(db.Integer(), db.ForeignKey('employees.id'))  # Foreign key
  ```
  Note: In these classes, we are assuming that an employee can’t have more than one driver license. So the relationship between an employee and driver license is one-to-one.



## Many-to-Many Relationship 
  
- A many-to-many relationship requires an extra table know as association table. Consider the example of a blog site:

  A blog post is usually associated with one or more tags. Similarly, a tag is also associated with one or more posts. So there is a many-to-many relationship between `posts` and `tags`.
  
  The solution is to create a new table called association table by defining 2 foreign keys referencing `post.id` and `tag.id` columns. the post and tags is implemented as a two one-to-many relationship. The first one-to-one relationship is between `posts` and `post_tags` table and the second is between `tags` and `post_tags` table
  
  ```python
  
  class Category(db.Model):
      # ...
          def __repr__(self):
          return "<{}:{}>".format(id, self.name)

  post_tags = db.Table('post_tags',
      db.Column('post_id', db.Integer, db.ForeignKey('posts.id')),
      db.Column('tag_id', db.Integer, db.ForeignKey('tags.id'))
  )

  class Post(db.Model):
      # ...

  class Tag(db.Model):
      # ...
      created_on = db.Column(db.DateTime(), default=datetime.utcnow)
      posts = db.relationship('Post', secondary=post_tags, backref='tags')
  #...
  
  ```
  In lines 7-10, we are defining an association table as an object of db.Table(). The first argument to db.Table() is the name of the table and additional arguments are the columns which are represented by instances of db.Column(). The syntax of creation association table may appear slightly odd as compared to the model class. This is because the association table is created using SQLAlchemy Core, which is another facet of SQLAlchemy. To learn more about SQLAlchemy visit our SQLAlchemy tutorial.
  
  Next, we have to tell our model class the association table we want to use. That’s the job of secondary keyword argument. In line 18, we are calling db.relationship() with the secondary argument set to post_tags. Although we have defined the relationship in the Tag model, we could just as easily defined it in the Post model.

Let’s say we have a Post object p, then we can access all its tags as p.tags. Similarly, Given a Tag object t, we can access all the posts under it as t.posts.

  
