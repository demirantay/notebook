# Model Best Practices

Models are the foundation of every django project we shouldnt rush to write any code while we are dealing with models the costs may be terrible in the months or years to come for a simple "glue fix" on your models.

## Basics 

- There should be NO more than 5 models per app. If it is more think about breaking it up.

- You can get rid of all of DRY code such as creation_date and etc. in your models with inheritance but be aware that inheritance with django is a tricky subject.

- Dont worry about the numbers of your model migrations. If the number of migrations becomes unwidely use `squashmigrations` to bring them to heel.

- ** Always backup the database **

## Model design

- Use `null=True` on only int,float fields and relation fields such as m2m one2m foreign key.

- Except for boolean field you can use blank=True, never use it on boolean field.
