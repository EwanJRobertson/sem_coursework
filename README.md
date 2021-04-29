# Software Engineering Methods

- Master Build Status [![Build Status](https://travis-ci.com/EwanJRobertson/sem_coursework.svg?branch=main)](https://travis-ci.com/EwanJRobertson/sem_coursework)
- Develop Build Status [![Build Status](https://travis-ci.org/EwanJRobertson/sem_coursework.svg?branch=develop)](https://travis-ci.org/EwanJRobertson/sem_coursework)
- License [![LICENSE](https://img.shields.io/github/license/EwanJRobertson/sem_coursework.svg?style=flat-square)](https://github.com/EwanJRobertson/sem_coursework/blob/master/LICENSE)
- Release [![Releases](https://img.shields.io/github/release/EwanJRobertson/sem_coursework/all.svg?style=flat-square)](https://github.com/EwanJRobertson/sem_coursework/releases)
- CodeCov [![codecov](https://codecov.io/gh/EwanJRobertson/sem_coursework/branch/main/graph/badge.svg?token=t6aek89no2)](https://codecov.io/gh/EwanJRobertson/sem_coursework)



To access the csv file containing the query results on Windows:

    - open powershell

    - run the command: docker ps -a

    - run the command: docker cp <sem_coursework_app CONTAINER ID>:/tmp/query-results.csv C:/Users/<your-filepath>
        replacing <sem_coursework_app CONTAINER ID> with the container id of the app container displayed from running the first command 
        and replacing <your-filepath> with where you want the file to be saved to


###Requirements Met:
> 32 requirements of 32 have been implemented, which is 100%.

| ID    | Name | Met  | Screenshot |
|-------|------|------|------------|
| 1     | All the countries in the world organised by largest population to smallest. | Yes | ![](query-results-img/1.png?raw=true) |
| 2     | All the countries in a continent organised by largest population to smallest. | Yes |  ![](query-results-img/2.png?raw=true) |
| 3     | All the countries in a region organised by largest population to smallest. | Yes | ![](query-results-img/3.png?raw=true) |
| 4     | The top N populated countries in the world where N is provided by the user. | Yes | ![](query-results-img/4.png?raw=true) |
| 5     | The top N populated countries in a continent where N is provided by the user. | Yes |  ![](query-results-img/5.png?raw=true) |
| 6     | The top N populated countries in a region where N is provided by the user. | Yes | ![](query-results-img/6.png?raw=true) |
| 7     | All the cities in the world organised by largest population to smallest.| Yes | ![](query-results-img/7.png?raw=true) |
| 8     | All the cities in a continent organised by largest population to smallest. | Yes |  ![](query-results-img/8.png?raw=true) |
| 9     | All the cities in a region organised by largest population to smallest. | Yes | ![](query-results-img/9.png?raw=true) |
| 10    | All the cities in a country organised by largest population to smallest. | Yes | ![](query-results-img/10.png?raw=true) |
| 11    | All the cities in a district organised by largest population to smallest. | Yes |  ![](query-results-img/11.png?raw=true) |
| 12    | The top N populated cities in the world where N is provided by the user. | Yes | ![](query-results-img/12.png?raw=true) |
| 13    | The top N populated cities in a continent where N is provided by the user. | Yes |  ![](query-results-img/13.png?raw=true) |
| 14    | The top N populated cities in a region where N is provided by the user. | Yes | ![](query-results-img/14.png?raw=true) |
| 15    | The top N populated cities in a country where N is provided by the user. | Yes | ![](query-results-img/15.png?raw=true) |
| 16    | The top N populated cities in a district where N is provided by the user. | Yes |  ![](query-results-img/16.png?raw=true) |
| 17    | All the capital cities in the world organised by largest population to smallest. | Yes | ![](query-results-img/17.png?raw=true) |
| 18    | All the capital cities in a continent organised by largest population to smallest. | Yes | ![](query-results-img/18.png?raw=true) |
| 19    | All the capital cities in a region organised by largest to smallest. | Yes | ![](query-results-img/19.png?raw=true)  |
| 20    | The top N populated capital cities in the world where N is provided by the user. | Yes | ![](query-results-img/20.png?raw=true) |
| 21    | The top N populated capital cities in a continent where N is provided by the user. | Yes | ![](query-results-img/21.png?raw=true) |
| 22    | The top N populated capital cities in a region where N is provided by the user. | Yes |  ![](query-results-img/22.png?raw=true) |
| 23    | The population of people, people living in cities, and people not living in cities in each continent. | Yes | ![](query-results-img/23.png?raw=true) |
| 24    | The population of people, people living in cities, and people not living in cities in each region. | Yes | ![](query-results-img/24.png?raw=true) |
| 25    | The population of people, people living in cities, and people not living in cities in each country. | Yes |  ![](query-results-img/25.png?raw=true) |
| 26    | The population of the world.| Yes | ![](query-results-img/26.png?raw=true) |
| 27    | The population of a continent. | Yes | ![](query-results-img/27.png?raw=true) |
| 28    | The population of a region. | Yes | ![](query-results-img/28.png?raw=true)  |
| 29    | The population of a country. | Yes | ![](query-results-img/29.png?raw=true) |
| 30    | The population of a district. | Yes | ![](query-results-img/30.png?raw=true) |
| 31    | The population of a city. | Yes |  ![](query-results-img/31.png?raw=true) |
| 32    | The percentage of the population of the world which speak either Chinese, English, Hindi, Spanish or Arabic | Yes |  ![](query-results-img/32.png?raw=true) |

