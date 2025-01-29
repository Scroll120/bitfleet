<!-- PROJECT LOGO -->
<div align="center">
  <h3 align="center">Bitfleet</h3>

  <p align="center">
    A Springboot Project for Naval Enthusiasts!
  </p>
</div>

![alt text](https://i.imgur.com/mzBTJni.png)


<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li>
      <a href="#running-the-app">Runnig the app</a>
    </li>
    <li>
      <a href="#features">Features</a>
    </li>
    <li>
      <a href="#roadmap">Roadmap</a>
    </li>
    <li>
      <a href="#contribute">Contribute</a>
    </li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Bitfleet is a petproject that focuses on naval battle simulations, ship and fleet management, from the comfort of your own web browers!
Utilizing algorithms with added randomness to calculate naval engagemenets between fleets, Bitfleet is a passion project that strives to create a fun game inspired by the likes of Battleship!

### Built With

![JavaScript][JavaScript-url] ![React][React-url] ![HTML5][HTML5-url] ![Springboot][boot-url] ![Postgre][postgre-url] ![CSS3][CSS3-url]



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up of the app and run it smoothly follow these simple guides!

### Prerequisites

Before you begin, ensure you have met the following requirements:

* IDE with JDK version of 22 and Java version of 17
* SQL cabale Database (Postgre recommended)
* NPM, required for running the frontend locally

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/Scroll120/bitfleet.git
   ```

2. Open the backend through the pom.xml, and set up your IDE environmental variables!
   * DB_URL - The url by which the application can connect to your datbase (recommending PostgreSql!)
   * DB_USERNAME - The username to log into the database
   * DB_PASSWORD - The password to log into the database
  
3. Navigate to the ./frontend folder, and install the node packages!
   ```sh
   npm install
   ```
   
<!-- RUNNING THE APP -->
## Running the app
1. Start the backend by launching the BitfleetApplication class!

2. Start the frontend by executing npm run dev in the ./frontend folder!
   ```sh
   npm run dev
   ```
3. The backend runs on [http://localhost:8080](http://localhost:8080)
4. The frontend runs on [http://localhost:5173](http://localhost5173)

5. Dummy User provided under:
   * Username: John Doe 
   * Password: 123

<!-- FEATURES -->
## Features
- Storing and selecting your ships and fleets!
- Engaging randomly selected fleets of other players!

<!-- ROADMAP -->
## Roadmap

Below is a list of completed and planned features for the project. Checkmarks indicate implemented features:
- [x] Storing and handling Admirals (Users), Ships, and Fleets
- [x] Selecting and randomizing opposing fleets
- [ ] Battle Algorithm
- [ ] Managing Fleet and Ship Statuses
- [ ] Enchanced Frontend with responsive single-window design
- [ ] Authentications
- [ ] Deploy the app using Docker and make it publicly accessible
- [ ] Implment a fleshed-out ship designer

<!-- CONTRIBUTE -->
## Contribute

If you'd like to contribute to the project feel free to do so! Open Source projects are meant to be shared with others!
1. Fork the Project
2. Create your Own Feature Branch
3. Commit your Changes
4. Push to your branch
5. Create a Pull Request for review!

<!-- CONTACT -->
## Contact

György Kocsis - [GitHub Profile](https://github.com/Scroll120)

Project Link: [https://github.com/Scroll120/bitfleet](https://github.com/Scroll120/bitfleet)

<!-- License -->
## License

Distributed under the Apache-2.0 License!

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[React-url]: https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=react&logoColor=black
[JavaScript-url]: https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black
[postgre-url]: https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white
[HTML5-url]: https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white
[CSS3-url]: https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white
[boot-url]: https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white
