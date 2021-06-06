# Liquid Galaxy OSC App
An Android App for Liquid Galaxy which uses the OSC Protocol

## CONTENTS
- Android Code (LiquidGalaxyOSCSender)
- OSC Listener (OSCServer.py)
- Video (lgOSCvid.mp4)

## USAGE INSTRUCTIONS
- For VMs, disable firewall:
```
$ sudo ufw disable
$ sudo iptables -F
```
- Prerequisite: KML Uploader API running on master
- Put master's IP in `MainActivity.java` in Android code
- Put master's IP in `OSCServer.py`
- Run OSC Listener on master: <br>
`$ python3 OSCServer.py`
- Install Android app
- Click any button and Google Earth should move to that city

## WORKING
The Android app sends the OSC message to the OSC Server serving on the master. The OSC server is coded in python and once it receives a message, it makes a GET request to the KML API.
