#Project Pump It Up
200212 project start

#진행순서
=========
>*Vmware Workstation 15 Pro 설치
>*Ubuntu 18.04 설치
>   >##Error 발생 (Some index files failed to download)
>   >   >sudo vi /etc/apt/sources.list
```
:%s/us.archive.ubuntu.com/ftp.daum.net
```
>   >*Pycharm 설치
```
    sudo apt-get update
    sudo apt-get upgrade
    sudo apt install snapd snapd-xdg-open
    sudo snap install pycharm-community --classic
```
>   >*maria DB 설치
``` 
    sudo apt-get install mariadb-server
```

>   >*pip 설치
```
    sudo apt-get install python-pip
```
>   >*django 설치
```
    sudo apt-get upgrade && sudo apt-get upgrade -y
    sudo apt-get install python3-pip python3-dev

    pip3 -V

    pip3 install virtualenv virtualenvwrapper
    virtualenv --python=3.6 python_env
    cd python_env
    source bin/activate
    pip install django
    django-admin startproject mysite 
```