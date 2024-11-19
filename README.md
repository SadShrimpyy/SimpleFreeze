![Logo](https://i.imgur.com/5eHUfYt.png)

#### SimpleFreeze
Check the plugin on [SpigotMC](https://www.spigotmc.org/resources/simplefreeze-freeze-unfreeze-actions-permissions-exempt-list-name-uuid-more.108590/ "SpigotMC.org")

## Description
Through this plugin you will be able to manage the freezing of a player; selecting which actions he can perform, and which he cannot.


## Features
* **Recognizes 14 actions** (events), and prevents a frozen player from performing them, **notifying** those with permission of the attempt. Can be _customized in the config.yml_
* **Select players exempt from freezing** _by name or UUID_. Can be _customized in the config.yml_
* **100% translatable** via messages.yml
* A command to freeze one player
* A command to freeze all the online players
* A command to thaw one player
* A command to thaw all the online players


## Commands
* `/freeze reload`: Reload the plugin
* `/freeze help`: View the generic help menu
* `/freeze freeze <name>`: Freeze a specific player
* `/freeze freeze *`: Freeze all the online players
* `/freeze thaw <name>`: Thaw a specific player
* `/freeze thaw *`: Thaw all the online players


## Permissions
* **simplefreeze.completer**: Access the use of the TabCompleter
* **simplefreeze.reload**: Access the use of the `/freeze reload` command
* **simplefreeze.help**: Access the use of the `/freeze help` command
* **simplefreeze.freeze**: Access the use of the `/freeze freeze <player>` command
* **simplefreeze.freeze.all**: Access the use of the `/freeze freeze *` command
* **simplefreeze.thaw**: Access the use of the `/freeze thaw <player>` command
* **simplefreeze.thaw.all**: Access the use of the `/freeze thaw *` command
* **simplefreeze.notify**: Accepts receipt of notifications ineerent to: freezing, thawing, and related events