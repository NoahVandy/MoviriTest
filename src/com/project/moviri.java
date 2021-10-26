package com.project;

import com.project.Models.Bandwidth;
import com.project.Models.NetworkBandwidthUtilization;
import com.project.Models.NetworkBitrate;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Default class to run the application
 */
public class moviri {
    public static void main(String[] args) throws FileNotFoundException {

        // create lists of data from csv files along with result list
        List<Bandwidth> bandwidthList = getArrayFromBandwidth("src//bandwidth.csv");
        List<NetworkBitrate> networkBitrateList = getArrayFromNetBitRate("src//netbitrate.csv");
        List<NetworkBandwidthUtilization> networkBandwidthUtilizationList = new ArrayList();

        // loop through each list and combine the data
        for(NetworkBitrate n : networkBitrateList) {
            for(Bandwidth b : bandwidthList) {
                // check if bandwidth correlates with networkBitRate
                if(n.getServer().equals( b.getServer()) && n.getInterfaceName().equals(b.getInterfaceName())) {
                    networkBandwidthUtilizationList.add(new NetworkBandwidthUtilization(n.getTimestamp(), n.getServer(), n.getInterfaceName(), n.getNetBitRate(), b.getBandwidth()));
                }
            }
        }

        // print out result
        for(NetworkBandwidthUtilization n : networkBandwidthUtilizationList) {
            System.out.println(n.toString());
        }
    }

    /**
     * returns a List of type NetworkBitrate from the input csv file
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static List<NetworkBitrate> getArrayFromNetBitRate(String file) throws FileNotFoundException {

        // create scanner to read csv file
        Scanner scanner = new Scanner(new File(file));

        // skip file header
        scanner.nextLine();

        // make list to add objects to
        List<NetworkBitrate> networkBitrateList = new ArrayList();

        // loop through file creating bandwith objects and adding them to list
        while(scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date parsedDate = simpleDateFormat.parse(line[0]);
                Timestamp timestamp = new Timestamp(parsedDate.getTime());
                networkBitrateList.add(new NetworkBitrate(timestamp, line[1], line[2], Float.parseFloat(line[3])));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        scanner.close();
        return networkBitrateList;
    }

    /**
     * returns a List of type NetworkBitrate from the input csv file
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static List<Bandwidth> getArrayFromBandwidth(String file) throws FileNotFoundException {

        // create scanner to read csv file
        Scanner scanner = new Scanner(new File(file));

        // skip file header
        scanner.nextLine();

        // make list to add objects to
        List<Bandwidth> bandwidthList = new ArrayList();

        // loop through file creating bandwith objects and adding them to list
        while(scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");
            try {
                bandwidthList.add(new Bandwidth(line[0], line[1], Float.parseFloat(line[2])));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        scanner.close();
        return bandwidthList;
    }
}
