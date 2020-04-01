# How To Set Up Django with Postgres, Nginx, and Gunicorn on Ubuntu 16.04

- Django is a powerful web framework that can help you get your Python application or website off the ground. Django includes a simplified development server for testing your code locally, but for anything even slightly production related, a more secure and powerful web server is required.

  In this guide, we will demonstrate how to install and configure some components on Ubuntu 16.04 to support and serve Django applications. We will be setting up a PostgreSQL database instead of using the default SQLite database. We will configure the Gunicorn application server to interface with our applications. We will then set up Nginx to reverse proxy to Gunicorn, giving us access to its security and performance features to serve our apps.

<br>
<br>

# Pre-requisites and Goals

- In order to complete this guide, you should have a fresh Ubuntu 16.04 server instance with a non-root user with sudo privileges configured.

  We will be installing Django within a virtual environment. Installing Django into an environment specific to your project will allow your projects and their requirements to be handled separately.

  Once we have our database and application up and running, we will install and configure the Gunicorn application server. This will serve as an interface to our application, translating client requests in HTTP to Python calls that our application can process. We will then set up Nginx in front of Gunicorn to take advantage of its high performance connection handling mechanisms and its easy-to-implement security features.

<br>
<br>

# Install the packages from the Ubuntu Repositories

<br>
<br>

# Create the PostgreSQL database and user


<br>
<br>

# Create Python Virtual Environment

<br>
<Br>
 

# Create and Configure a New Django Project

<br>
<Br>
  

# Create a Gunicorn systemd Service File

<br>
<Br>
 

# Check for the Gunicorn Socket File

<br>
<Br>
 

# Configure Nginx to Proxy Pass to Gunicorn

<br>
<br>


# Troubleshooting Nginx and Gunicorn
