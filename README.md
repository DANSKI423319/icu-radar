# COMP3000, Intensive Care Unit Visualizer
![letterbox-image](https://user-images.githubusercontent.com/43968979/119660645-673d3a80-be27-11eb-9e74-bb3e573fdf91.jpg)
> [Video Link Here]

This application uses a structured **CSV** **File** and organises the fields into a data visualizing application meant to graphically represent the recovery of patients in the **Intensive Care Unit** based off their **CPAX, MRC and SOFA** medical assessments. This is made with with **Java's Graphics** component which builds a **Radar Chart** using mathematic formulae. It offers a plethora of visualization tools so that the user can expose different patterns of data.

## 🏗️ Installation
Download the recent build from this repository, which *should* be opened with the **NetBeans IDE.** Start the application by running **[radarFrame.java](http://radarframe.java), this** is found in the **viewControllers** directory.

## 💿 Usage
When the application is running, use the interface to select a file you would like to base the visualizations from. This file must follow a strict structure, a template for this structure can be found in the main project directory.

## ℹ️ Information
This repository is the product of a final year dissertation project based on the needs of a local hospitals' intensive care unit, and is a free contribution to an ongoing project which aims to better the overall structure of programs being used in that environment.

### ⚙ Requirements
| Requirement                                                                   	| Importance    	| Complete 	|
|-------------------------------------------------------------------------------	|---------------	|----------	|
| The user can start the application                                            	| Essential     	| ✅        	|
| The user can select a dataset                                                 	| Essential     	| ✅        	|
| The user can select a patient                                                 	| Essential     	| ✅        	|
| The user can select a date of observations, connected to the selected patient 	| Essential     	| ✅        	|
| The user can view a chart of any of the assessment scores                     	| Essential     	| ✅        	|
| The user can view a chart of multiple assessment scores at once               	| Essential     	| ✅        	|
| The user can view the assessment scores in a table within the interface       	| Essential     	| ✅        	|
| The user is given indication of missing data in the radar chart               	| Essential     	| ✅        	|
| The user can decide the colour of each assessment scores' chart               	| Non-Essential 	| ✅        	|
| The user can enable or disable parts of the chart                             	| Non-Essential 	| ✅        	|
| The user can enable or disable parts of the plot                              	| Non-Essential 	| ✅        	|
| The user can decide if a line is drawn between scores where a zero is present 	| Non-Essential 	| ✅        	|
| The user can decide if a line is drawn between scores where data is absent    	| Non-Essential 	| ✅        	|
| The user can export a PNG image file of the chart                             	| Non-Essential 	| ✅        	|
| The user can enable a key which links the scores to an adjacent table         	| Non-Essential 	| ✅        	|
| The user can remove duplicate entries from the proram                         	| Non-Essential 	| ❌        	|
| The user can view an alternate chart which is made of all three assessments   	| Non-Essential 	| ✅        	|
| The user can present the scores in a time animation                           	| Non-Essential 	| ✅        	|
| The user can decide if the number zero is visible                             	| Non-Essential 	| ✅        	|
| The user can replace missing data with the number zero                        	| Non-Essential 	| ✅        	|
| The user can search for patients via search bar                               	| Non-Essential 	| ❌        	|

### 🖼️ Other Images
![10602402-v2](https://user-images.githubusercontent.com/43968979/119660733-7b813780-be27-11eb-83ce-84537785c64b.jpg)
![10602402_tn](https://user-images.githubusercontent.com/43968979/119660751-7f14be80-be27-11eb-9631-53ddf926a9b8.png)
