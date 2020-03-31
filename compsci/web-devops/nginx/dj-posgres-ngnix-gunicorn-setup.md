# How To Set Up Django with Postgres, Nginx, and Gunicorn on Ubuntu 16.04

- Django is a powerful web framework that can help you get your Python application or website off the ground. Django includes a simplified development server for testing your code locally, but for anything even slightly production related, a more secure and powerful web server is required.

  In this guide, we will demonstrate how to install and configure some components on Ubuntu 16.04 to support and serve Django applications. We will be setting up a PostgreSQL database instead of using the default SQLite database. We will configure the Gunicorn application server to interface with our applications. We will then set up Nginx to reverse proxy to Gunicorn, giving us access to its security and performance features to serve our apps.

<br>
<br>

---

<br>
<br>

# Pre-requisites and Goals

<br>
<br>

---

<br>
<br>

# Install the packages from the Ubuntu Repositories

<br>
<br>

---

<br>
<br>

# Create the PostgreSQL database and user


<br>
<br>

---

<br>
<br>

# Create Python Virtual Environment

<br>
<Br>
  
---

<br>
<br>

# Create and Configure a New Django Project

<br>
<Br>
  
---

<br>
<br>

# Create a Gunicorn systemd Service File

<br>
<Br>
  
---

<br>
<br>

# Check for the Gunicorn Socket File

<br>
<Br>
  
---

<br>
<br>

# Configure Nginx to Proxy Pass to Gunicorn

<br>
<br>

---

<br>
<br>

# Troubleshooting Nginx and Gunicorn
