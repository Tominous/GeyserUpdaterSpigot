# GeyserFloodgateUpdater
> Updating Geyser and Floodgate with ease.


This Addon/plugin allows you to update geyser without much effort.
Update Geyser with Commands or you can set them to Auto Update.


## Installation

Currently the updater only works on Geyser-spigot. Place the Downloaded jar in to your plugins folder and restart the server


Permissions:
```
AlysaaPlugin.geyserupdate
AlysaaPlugin.floodgateupdate
AlysaaPlugin.broadcast
```

Commands:
```
/geyserupdate
/floodgateupdate 
```

Auto-Updating:

```
You can set Auto-Updating on true in the config.yml, If set to true you will need to restart server manually before changes will take place.
```
Hard-Auto-Updating:

```
You can set Hard-Auto-Updating on true in the config.yml, If set to true make sure you have a working restart-script.
otherwise it will just shutdown the server.

```

## Usage

After you ran the command, it will download the latest build available on Jenkins.
Changes will only take place once the server has been restarted.

## Restart/reload

Please do not use the Reload command. this can cause errors on the geyser part. and most likely will break your server.


## Release History
* 0.0.2
    * Adding Hard Auto Updating
* 0.0.1
    * Work in progress, Added Geyser and Floodgate command and get code to work!

## Meta

AlysaaKobe (Jens) – jenscollaertprive@hotmail.com

Distributed under the MIT license. See ``LICENSE`` for more information.
