# LO54-project

## Prerequisits

### Database

To set-up the database, you got 3 choices :

#### Ever existing MySQL / MariaDB database

If you ever got, on your computer, an MySQL or MariaDB database set-up, you can simply execute the SQL scripts located in the [database/scripts](database/scripts/) directory

#### Using Docker

In the [database](database/) directory, there is a [docker-compose.yml](database/docker-compose.yml) file, that will build a custom Docker image based on MariaDB.

To launch it, just do :

```bash
# Go into the database directory
cd database

# Launch the server
sudo docker-compose up -d
```

#### Using Vagrant

If you are on Windows, it will probably be easier than installing Docker to use (Vagrant)[https://www.vagrantup.com/].

To use it, you need to install :
- [VirtualBox](https://www.virtualbox.org)
- [Vagrant](https://www.vagrantup.com/)

Once done, type :

```bash
# Go into the database directory, where is located the Vagrantfile
cd database

# Launch the VM and install the MySQL server
vagrant up
```

It will :
- Create a virtual machine based on [Ubuntu 18.04](http://releases.ubuntu.com/18.04/)
- Install Docker and all of it's prerequisits
- Launch the MariaDB server