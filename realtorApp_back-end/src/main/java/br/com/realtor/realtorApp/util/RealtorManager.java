package br.com.realtor.realtorApp.util;

import br.com.realtor.realtorApp.entity.realtor.Realtor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class RealtorManager {


    // The code basic functionality works just fine, however it still needs to be refactored - TODO
    public void saveProfilePicture(Realtor realtor) throws Exception {
        String imageURL = realtor.getImageURL();
//        String destinationFile = ".\\testes.jpg";

        URL url = new URL(imageURL);
        BufferedImage image = ImageIO.read(url);

        ImageIO.write(image , "jpg", new File("C:\\Users\\jonas\\Documents\\Projetos\\Realtor\\realtorApp_back-end\\src\\main\\java\\br\\com\\realtor\\realtorApp\\util\\images\\profile.jpg"));

    }
}