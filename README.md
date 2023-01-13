# DukePasswordManager

You need to install the correct JDK. To do that open the project in IntelliJ and a blue banner will show up. Select 'Install JDK'.

## Usage
If you start the application for the first time you need to set a master password. This will be stored as a hash inside the project folder. That means that on the second start of the application you need to log in with your master password.
You can select a worflow by typing the number of it.
If you created some credentials in a session, you can close the application via workflow 99 (EXIT) and the credentials will be stored encrypted inside of the project folder. On the next start of the application they will be loaded.
