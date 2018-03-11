#!/bin/bash
sudo systemctl stop pictorial.service
sudo chown pictorial:pictorial PictorialArt/JARs/PictorialArt-0.1.0.jar.tmp
sudo mv PictorialArt/JARs/PictorialArt-0.1.0.jar.tmp PictorialArt/JARs/PictorialArt-0.1.0.jar
sudo chmod 775 PictorialArt/JARs/PictorialArt-0.1.0.jar
sudo systemctl stop pictorial.service
