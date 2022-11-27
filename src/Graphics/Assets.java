package Graphics;

import java.awt.image.BufferedImage;

public class Assets {
    //PLAYER SHIPS
    public static BufferedImage lightCruiserBlue,lightCruiserRed,lightCruiserGreen,lightCruiserOrange,
                                heavyCruiserBlue,heavyCruiserRed,heavyCruiserGreen,heavyCruiserOrange,
                                starCruiserBlue,starCruiserRed,starCruiserGreen,starCruiserOrange;

    //LASERS
    public static BufferedImage blueLaser, greenLaser, redLaser;

    //ASTEROIDS
    public static BufferedImage[] bigs = new BufferedImage[4];

    //NUMBERS
    public static BufferedImage[] numbers = new BufferedImage[9];

    public static void init() {
        lightCruiserBlue = Loader.ImageLoader("/Images/PNG/SpaceShips/playerShip3_blue.png");
        lightCruiserRed = Loader.ImageLoader("/Images/PNG/SpaceShips/playerShip3_red.png");
        lightCruiserGreen = Loader.ImageLoader("/Images/PNG/SpaceShips/playerShip3_green.png");
        lightCruiserOrange = Loader.ImageLoader("/Images/PNG/SpaceShips/playerShip3_orange.png");

        heavyCruiserBlue = Loader.ImageLoader("/Images/PNG/SpaceShips/playerShip2_blue.png");
        heavyCruiserRed = Loader.ImageLoader("/Images/PNG/SpaceShips/playerShip2_red.png");
        heavyCruiserGreen = Loader.ImageLoader("/Images/PNG/SpaceShips/playerShip2_green.png");
        heavyCruiserOrange = Loader.ImageLoader("/Images/PNG/SpaceShips/playerShip2_orange.png");

        starCruiserBlue = Loader.ImageLoader("/Images/PNG/SpaceShips/playerShip1_blue.png");
        starCruiserRed = Loader.ImageLoader("/Images/PNG/SpaceShips/playerShip1_red.png");
        starCruiserGreen = Loader.ImageLoader("/Images/PNG/SpaceShips/playerShip1_green.png");
        starCruiserOrange = Loader.ImageLoader("/Images/PNG/SpaceShips/playerShip1_orange.png");

        blueLaser = Loader.ImageLoader("/Images/PNG/Lasers/laserBlue01.png");
        redLaser = Loader.ImageLoader("/Images/PNG/Lasers/laserRed01.png");
        greenLaser = Loader.ImageLoader("/Images/PNG/Lasers/laserGreen01.png");

        for(int i = 0; i < bigs.length; i++)
            bigs[i] = Loader.ImageLoader("/Images/PNG/Meteors/meteorGrey_big"+(i+1)+".png");

        for(int i = 0; i < numbers.length; i++)
            numbers[i] = Loader.ImageLoader("/Images/PNG/Numbers/"+(i)+".png");
    }
}
