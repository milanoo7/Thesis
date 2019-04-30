import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;
///*

public class Main {
    public static void main(String args[]) {


        /////////// Device attributes
        System.out.println(" Enter the device credentials and certificate info \n" +
                " KEYs   Mandatory attributes list  ------- KEYs  Optional Attributes list \n" +
                "DA1=    device ID " + "\t\t\t\t           Def= date of issue & Validity \n" +
                "DA2=    Mac add " + "\t\t\t               DC1= CA Certificate serial num \n" +
                "DA3=    firmware versio  DA4= firmware naem + \t\t\t       DC2  Signature of CA\n" +
                "ODA1    Device name " + "\t\t\t           DC3= Device public key \n" +
                "ODA2=   Device serial num" + "\t\t\t      ODC1= CA issuer" +
                "ODA4 =  Device description \n" +
                "ODA5=   hardware version\n" +
                "CF=     device configure \n" +
                "ON=     device on \n" + "CN= To communication history\n" + "\n");

        //);

        Scanner scanner = new Scanner(System.in);
        System.out.println(" How many attributes you have FOR DEVICE A ");
        Scanner scanner1 = new Scanner(System.in);
        int num = scanner1.nextInt();
        int T1 = 0;
        int T2 = 0;
        int T3 = 0;
        int k = 0;
        String[] keep = new String[num];
        DeviceAttribute d1 = new DeviceAttribute();
        DeviceCertificate dc1 = new DeviceCertificate();
        DeviceStatus ds1 = new DeviceStatus();
        for (int i = 1; i < num + 1; i++) {


            System.out.println(" Enter Key of " + i + " attributes you have for DEVICE A ");
            String numatt = scanner.next();

            keep[k] = numatt;
            k++;
            switch (numatt) {
                case "oda1":
                    System.out.println("Enter Device Name: Max lenght = 10");
                    String device_name = scanner.next();
                    while (device_name.length() > 10) {
                        System.out.println("Name is too long");
                        device_name = scanner.next();
                    }
                    d1.setName(device_name);
                    System.out.println("Accepted");


                    break;

                case "oda4":
                    System.out.println("Enter Device Description Max=20 character");
                    String desc = scanner.next();
                    while (desc.length() > 20) {
                        System.out.println("Description is too long");
                        desc = scanner.next();
                    }
                    d1.setDesc(desc);
                    System.out.println("Accepted");


                    break;


                case "da1":
                    System.out.println("Enter Device ID:Max length = 999");
                    int id = scanner.nextInt();

                    while (id > 999) {
                        System.out.println("Device ID is out of range enter again");
                        id = scanner.nextInt();

                    }
                    d1.setDeviceID(id);
                    System.out.println("Accepted");
                    break;


                case "da2":
                    System.out.println("Enter Physical address (Mac address) length = 12");
                    String macadd = scanner.next();
                    while (macadd.length() != 12) {
                        System.out.println("Mac add is out of range");
                        macadd = scanner.next();
                    }
                    d1.setMacadd(macadd);
                    System.out.println("Accepted");
                    break;

                case "da3":
                    System.out.println("Enter Firmware Version");
                    double firmNum = scanner.nextDouble();
                    double d = Double.valueOf(firmNum);
                    d1.setFirmNum(d);
                    break;

                case "da4":
                    System.out.println("Enter Firmware name Max range = 8");
                    String firmwareVendor = scanner.next();
                    while (firmwareVendor.length() > 8) {
                        System.out.println("Firmware name out of range");
                        firmwareVendor = scanner.next();
                    }
                    d1.setFirmVendor(firmwareVendor);
                    System.out.println("Accepted");

                    break;

                case "dc3":
                    System.out.println("Enter device public key = length =10");
                    String publickey = scanner.next();
                    while (publickey.length() != 10) {
                        System.out.println("public key  out of range enter again");
                        publickey = scanner.next();
                    }
                    d1.setPublicKey(publickey);
                    System.out.println("Accepted");


                    break;


                case "oda5":
                    System.out.println("Enter Hardware Version");
                    float hardwareVersion = scanner.nextFloat();
                    d1.setHardwareVersion(hardwareVersion);
                    System.out.println("Accepted");
                    break;

                case "oda2":
                    System.out.println("Enter Device Serial Number Max length = 99999");
                    int serialNumber = scanner.nextInt();
                    while (serialNumber > 99999) {
                        System.out.println("Device serial number is out of range ");
                        serialNumber = scanner.nextInt();
                    }
                    d1.setSerialNumber(serialNumber);
                    System.out.println("Accepted");

                    break;


                ////////////Device status
                //System.out.println("Device Status");


                case "on":
                    System.out.println("Device On");
                    boolean isOn = scanner.nextBoolean();
                    ds1.setOn(isOn);
                    break;

                case "cf":
                    System.out.println("Device Configured");
                    boolean isConfigured = scanner.nextBoolean();
                    ds1.setIsconfigured(isConfigured);
                    break;


                ///////////Device certificate

                // System.out.println("Details about Digital certificate");


                case "odc1":
                    System.out.println("Enter issuer authority name Max= 10 char");
                    String issuer = scanner.next();
                    while (issuer.length() > 10) {
                        System.out.println("Name is too long");
                        issuer = scanner.next();
                    }

                    dc1.setIssuer(issuer);
                    System.out.println("Accepted");
                    break;

                case "dc1":
                    System.out.println("Enter serial number Max= 5 digit");
                    int sernum = scanner.nextInt();
                    while (sernum > 99999) {
                        System.out.println("serial number is out of bound");
                        sernum = scanner.nextInt();
                    }
                    dc1.setSerialNumber(sernum);
                    System.out.println("Accepted");


                    break;

                case "dc2":
                    System.out.println("Enter the digital signature length = 12");
                    String signalgo = scanner.next().toUpperCase();
                    while (signalgo.length() != 12) {
                        System.out.println("signature is out of bound");
                        signalgo = scanner.next().toUpperCase();
                    }

                    dc1.setSignAlgo(signalgo);
                    System.out.println("Accepted");

                    break;

                case "def":
                    System.out.println("Enter the date of issue MM/dd/yyyy");

                    String expectedPattern = "MM/dd/yyyy";
                    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
                    try {
                        // (2) give the formatter a String that matches the SimpleDateFormat pattern
                        String userInput = scanner.next();
                        Date date = formatter.parse(userInput);

                        // (3) prints out "Tue Sep 22 00:00:00 EDT 2009"
                        dc1.setDateOfIssue(date);

                    } catch (ParseException e) {
                        // execution will come here if the String that is given
                        // does not match the expected format.
                        e.printStackTrace();
                    }
                    System.out.println("Enter validity staus");
                    boolean validity = scanner.nextBoolean();
                    dc1.setValidity(validity);
                    System.out.println("Accepted");

                    break;


                case "cn":
                    break;


            }
        }
        System.out.println("device A attributes list number" + Arrays.toString(keep));

        //////personal traints calculation for device 1////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("DEVICE A personal trust level ");
        //////////////personal traints  level 3 ///////////////////////////////////////////////
        if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 5;
            System.out.println("Level 5 Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d1.getDeviceID() != 0 && d1.getFirmNum() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");







        } else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }


        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }

        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSerialNumber() != 0) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d1.getFirmNum() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d1.getDeviceID() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d1.getDeviceID() != 0 && d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }

        else if (d1.getMacadd() != null && d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }



        else if (d1.getMacadd() != null && d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }


        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null && dc1.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }





        else if (d1.getDeviceID() != 0  && d1.getFirmNum() != 0  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getDeviceID() != 0  && d1.getFirmNum() != 0  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getDeviceID() != 0  && d1.getFirmNum() != 0  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null && dc1.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }



        else if (d1.getDeviceID() != 0  && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getDeviceID() != 0  && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null && dc1.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }












        else if (d1.getMacadd() != null  && d1.getFirmNum() != 0  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getMacadd() != null && d1.getFirmNum() != 0  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getMacadd() != null && d1.getFirmNum() != 0  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null && dc1.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }



        else if (d1.getMacadd() != null && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getMacadd() != null && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getMacadd() != null && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null && dc1.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getFirmNum() != 0  && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getFirmNum() != 0 && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getFirmNum() != 0  && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null && dc1.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }


        else if (d1.getDeviceID() != 0 && d1.getFirmNum() != 0 && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getFirmNum() != 0 && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getFirmNum() != 0 && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }



        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }



        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0   && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0  && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0  &&  d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true  ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }















        ////////////////////////////////////////2 level /////////////////////////////////////////////////


        else if (d1.getDeviceID() != 0 && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if (d1.getMacadd() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if ( d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }
        else if (d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }




        else if (d1.getDeviceID() != 0 && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null  && d1.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if (d1.getMacadd() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null  && d1.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if ( d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null  && d1.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }
        else if (d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }






        else if (d1.getDeviceID() != 0 && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null && dc1.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if (d1.getMacadd() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null && dc1.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if ( d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null && dc1.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }
        else if (d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getValidity() == true && d1.getPublicKey() != null && dc1.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

















        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d1.getDeviceID() != 0 && d1.getFirmVendor() != null && d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d1.getMacadd() != null && d1.getFirmVendor() != null && d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmVendor() != null && dc1.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d1.getDeviceID() != 0 && d1.getFirmVendor() != null && d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d1.getMacadd() != null && d1.getFirmVendor() != null && d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null  && dc1.getDateOfIssue() != null && dc1.getSignAlgo() != null ) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d1.getDeviceID() != 0 &&  d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d1.getDeviceID() != 0 &&  d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null && dc1.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d1.getMacadd() != null && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d1.getMacadd() != null && d1.getFirmNum() != 0   && dc1.getDateOfIssue() != null && dc1.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d1.getFirmVendor() != null && d1.getFirmNum() != 0   && dc1.getDateOfIssue() != null && dc1.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }


        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null  && dc1.getDateOfIssue() != null && dc1.getSerialNumber() != 0 ) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d1.getDeviceID() != 0 &&  d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && dc1.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d1.getDeviceID() != 0 &&  d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null && dc1.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d1.getMacadd() != null && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && dc1.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d1.getMacadd() != null && d1.getFirmNum() != 0   && dc1.getDateOfIssue() != null && dc1.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d1.getFirmVendor() != null && d1.getFirmNum() != 0   && dc1.getDateOfIssue() != null && dc1.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }





        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null  && dc1.getDateOfIssue() != null && d1.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d1.getDeviceID() != 0 &&  d1.getFirmVendor() != null && dc1.getDateOfIssue() != null && d1.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d1.getDeviceID() != 0 &&  d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null && d1.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d1.getMacadd() != null && d1.getFirmVendor() != null  && dc1.getDateOfIssue() != null && d1.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d1.getMacadd() != null && d1.getFirmNum() != 0   && dc1.getDateOfIssue() != null && d1.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d1.getFirmVendor() != null && d1.getFirmNum() != 0   && dc1.getDateOfIssue() != null && d1.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }///////////////////////// level 1 ///////////////////////////////

        else if (d1.getDeviceID() != 0 && dc1.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");}
        else if (d1.getMacadd() != null && dc1.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");}
        else if ( d1.getFirmNum() != 0 && dc1.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");
        }
        else if (d1.getFirmVendor() != null && dc1.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");
        }


        else if ( dc1.getSignAlgo() != null  && dc1.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");}
        else if ( dc1.getSerialNumber() != 0 && dc1.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");}
        else if ( d1.getPublicKey() != null && dc1.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");
        }

        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null     && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null     && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getDeviceID() != 0 && d1.getFirmNum() != 0 && d1.getFirmVendor() != null     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmVendor() != null     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");







        } else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }


        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null     && dc1.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null     && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0 && d1.getFirmVendor() != null     && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getFirmNum() != 0 && d1.getFirmVendor() != null     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getDeviceID() != 0 && d1.getFirmVendor() != null     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getDeviceID() != 0 && d1.getFirmNum() != 0     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }


        else if (d1.getMacadd ()!= null && d1.getFirmNum() != 0     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }



        else if (d1.getMacadd()!= null && d1.getFirmNum() != 0     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0 && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null      && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null      && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null      && d1.getPublicKey() != null && dc1.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }





        else if (d1.getDeviceID() != 0  && d1.getFirmNum() != 0      && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0  && d1.getFirmNum() != 0      && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0  && d1.getFirmNum() != 0      && d1.getPublicKey() != null && dc1.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }



        else if (d1.getDeviceID() != 0  && d1.getFirmVendor() != null      && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0  && d1.getFirmVendor() != null      && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getFirmVendor() != null      && d1.getPublicKey() != null && dc1.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d1.getMacadd() != null  && d1.getFirmNum() != 0      && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getMacadd() != null && d1.getFirmNum() != 0      && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getMacadd() != null && d1.getFirmNum() != 0      && d1.getPublicKey() != null && dc1.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d1.getMacadd() != null && d1.getFirmVendor() != null      && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getMacadd() != null && d1.getFirmVendor() != null      && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getMacadd() != null && d1.getFirmVendor() != null      && d1.getPublicKey() != null && dc1.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getFirmNum() != 0  && d1.getFirmVendor() != null      && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getFirmNum() != 0 && d1.getFirmVendor() != null      && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getFirmNum() != 0  && d1.getFirmVendor() != null      && d1.getPublicKey() != null && dc1.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if (d1.getMacadd() != null     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d1.getFirmNum() != 0     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getFirmVendor() != null     && dc1.getSignAlgo() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0     && dc1.getSignAlgo() != null  && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if (d1.getMacadd() != null     && dc1.getSignAlgo() != null  && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d1.getFirmNum() != 0     && dc1.getSignAlgo() != null  && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getFirmVendor() != null     && dc1.getSignAlgo() != null && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0     && d1.getPublicKey() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if (d1.getMacadd() != null     && d1.getPublicKey() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d1.getFirmNum() != 0     && d1.getPublicKey() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getFirmVendor() != null     && d1.getPublicKey() != null && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmVendor() != null  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getDeviceID() != 0 && d1.getFirmVendor() != null && d1.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getMacadd() != null && d1.getFirmVendor() != null && d1.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d1.getDeviceID() != 0 && d1.getMacadd() != null && d1.getFirmVendor() != null  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getDeviceID() != 0 && d1.getFirmVendor() != null && d1.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getMacadd() != null && d1.getFirmVendor() != null && d1.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null    && dc1.getSignAlgo() != null ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d1.getDeviceID() != 0 &&  d1.getFirmVendor() != null   && dc1.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getDeviceID() != 0 &&  d1.getFirmNum() != 0   && dc1.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getMacadd() != null && d1.getFirmVendor() != null    && dc1.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d1.getMacadd() != null && d1.getFirmNum() != 0     && dc1.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d1.getFirmVendor() != null && d1.getFirmNum() != 0     && dc1.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null    && dc1.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d1.getDeviceID() != 0 &&  d1.getFirmVendor() != null   && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getDeviceID() != 0 &&  d1.getFirmNum() != 0   && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getMacadd() != null && d1.getFirmVendor() != null    && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d1.getMacadd() != null && d1.getFirmNum() != 0     && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d1.getFirmVendor() != null && d1.getFirmNum() != 0     && dc1.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0 && d1.getMacadd() != null    && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d1.getDeviceID() != 0 &&  d1.getFirmVendor() != null   && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getDeviceID() != 0 &&  d1.getFirmNum() != 0   && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d1.getMacadd() != null && d1.getFirmVendor() != null    && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d1.getMacadd() != null && d1.getFirmNum() != 0     && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d1.getFirmVendor() != null && d1.getFirmNum() != 0     && d1.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d1.getDeviceID() != 0   ) {
            T1 = 0;
            System.out.println("Level 0 Trust");}
        else if (d1.getMacadd() != null   ) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d1.getFirmNum() != 0   ) {
            T1 = 0;
            System.out.println("Level 0 Trust");
        }
        else if (d1.getFirmVendor() != null   ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }


        else if ( dc1.getSignAlgo() != null    ) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( dc1.getSerialNumber() != 0   ) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d1.getPublicKey() != null   ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }


















        randomnum r1 = new randomnum();
        int x = r1.randomint(0, T1);
        //  System.out.println(" Random value for A  " + x);


        ////////////////SWITCH CASE FOR 2nd DEVICE//////////////////////////////////////////////////////////////////////////////////////////
        Scanner scanner2 = new Scanner(System.in);
        System.out.println(" How many attributes you have FOR DEVICE B ");
        Scanner scanner3 = new Scanner(System.in);
        int num1 = scanner3.nextInt();
        String[] keep1 = new String[num1];
        int k1 = 0;

        DeviceAttribute d2 = new DeviceAttribute();
        DeviceCertificate dc2 = new DeviceCertificate();
        DeviceStatus ds2 = new DeviceStatus();


        for (int J = 1; J < num1 + 1; J++) {

            System.out.println(" Enter Key of" + J + " attributes you have for DEVICE 2 ");
            String numatt2 = scanner2.next();
            keep1[k1] = numatt2;
            k1++;

            switch (numatt2) {

                case "oda1":
                    System.out.println("Enter Device Name:MAX= 10 char");
                    String device_name2 = scanner2.next();
                    while (device_name2.length() > 10) {
                        System.out.println("Name is too long");
                        device_name2 = scanner2.next();
                    }
                    d2.setName(device_name2);
                    System.out.println("Accepted");
                    break;

                case "oda4":
                    System.out.println("Enter Device Description MAX = 20 char ");
                    String desc2 = scanner2.next();
                    while (desc2.length() > 20) {
                        System.out.println("Description is too long");
                        desc2 = scanner2.next();

                    }
                    d2.setDesc(desc2);
                    System.out.println("Accepted");
                    break;


                case "da1":
                    System.out.println("Enter Device ID: MAX = 3 digit");
                    int id2 = scanner2.nextInt();
                    while (id2 > 999) {
                        System.out.println("out of range");
                        id2 = scanner2.nextInt();
                    }
                    d2.setDeviceID(id2);
                    System.out.println("Accepted");
                    break;


                case "da2":
                    System.out.println("Enter Physical address (Mac address) length =12 ");
                    String macadd2 = scanner2.next();
                    while (macadd2.length() != 12) {
                        System.out.println("not in range try again");
                        macadd2 = scanner2.next();

                    }
                    d2.setMacadd(macadd2);
                    System.out.println("Accepted");
                    break;

                case "da4":
                    System.out.println("Enter Firmware Vendor MAX=8 char");
                    String firmwareVendor2 = scanner2.next();
                    while (firmwareVendor2.length() > 8) {
                        System.out.println("too long ");
                        firmwareVendor2 = scanner2.next();
                    }
                    d2.setFirmVendor(firmwareVendor2);
                    System.out.println("Accepted");
                    break;
                case "da3":
                    System.out.println("Enter Firmware Version");
                    double firmNum2 = scanner2.nextDouble();

                    d2.setFirmNum(firmNum2);
                    System.out.println("Accepted");
                    break;


                case "dc3":
                    System.out.println("Enter device public key MAX=10 digit");
                    String publickey2 = scanner2.next();
                    while (publickey2.length() != 10) {
                        System.out.println("too long");
                        publickey2 = scanner2.next();
                    }
                    d2.setPublicKey(publickey2);
                    System.out.println("Accepted");
                    break;


                case "oda5":
                    System.out.println("Enter Hardware Version");
                    float hardwareVersion2 = scanner2.nextFloat();
                    d2.setHardwareVersion(hardwareVersion2);

                    System.out.println("Accepted");
                    break;

                case "oda2":
                    System.out.println("Enter Device Serial Number MAX= 6 digit");
                    int serialNumber2 = scanner2.nextInt();
                    while (serialNumber2 > 99999) {
                        System.out.println("Out of range");

                    }
                    d2.setSerialNumber(serialNumber2);
                    System.out.println("Accepted");
                    break;


                ////////////Device status
                //System.out.println("Device Status");


                case "on":
                    System.out.println("Device On");
                    boolean isOn2 = scanner2.nextBoolean();
                    ds2.setOn(isOn2);
                    break;

                case "cf":
                    System.out.println("Device Configured");
                    boolean isConfigured2 = scanner2.nextBoolean();
                    ds2.setIsconfigured(isConfigured2);
                    break;


                ///////////Device certificate

                // System.out.println("Details about Digital certificate");


                case "oca1":
                    System.out.println("Enter issuer authority name");
                    String issuer2 = scanner2.next();
                    dc2.setIssuer(issuer2);
                    break;

                case "dc1":
                    System.out.println("Enter certificate serial number MAX= 6 digit");
                    int sernum2 = scanner2.nextInt();
                    while (sernum2 > 99999) {
                        System.out.println("serial number is too long ");
                        sernum2 = scanner2.nextInt();
                    }
                    dc2.setSerialNumber(sernum2);
                    System.out.println("Accepted");
                    break;

                case "dc2":
                    System.out.println("Enter the digital signature length= 12 char");
                    String signalgo2 = scanner2.next();
                    while (signalgo2.length() != 12) {
                        System.out.println("Out of range");
                        signalgo2 = scanner2.next();

                    }
                    dc2.setSignAlgo(signalgo2);
                    System.out.println("Accepted");
                    break;

                case "def":

                    System.out.println("Enter the date of issue MM/dd/yyyy");

                    String expectedPattern = "MM/dd/yyyy";
                    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
                    try {
                        // (2) give the formatter a String that matches the SimpleDateFormat pattern
                        String date2 = scanner2.next();
                        Date date = formatter.parse(date2);

                        dc2.setDateOfIssue(date);
                    } catch (ParseException e) {
                        // execution will come here if the String that is given
                        // does not match the expected format.
                        e.printStackTrace();
                    }
                    System.out.println("Enter validity status");
                    boolean validity2 = scanner2.nextBoolean();
                    dc2.setValidity(validity2);
                    System.out.println("Accepted");
                    break;


            }


        }
        System.out.println("device B attributes list number" + Arrays.toString(keep1));

        ////////////////////personal traints for Device 2 ///////////////////////////////////////////////////////////////////////////////////////

        ////////////////// rules for optional property

        System.out.println("DEVICE B personal trust level");

        if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 5;
            System.out.println("Level 5 Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d2.getDeviceID() != 0 && d2.getFirmNum() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");







        } else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }


        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }

        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSerialNumber() != 0) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d2.getFirmNum() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d2.getDeviceID() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d2.getDeviceID() != 0 && d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }

        else if (d2.getMacadd() != null && d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }



        else if (d2.getMacadd() != null && d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }


        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null && dc2.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }





        else if (d2.getDeviceID() != 0  && d2.getFirmNum() != 0  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getDeviceID() != 0  && d2.getFirmNum() != 0  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getDeviceID() != 0  && d2.getFirmNum() != 0  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null && dc2.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }



        else if (d2.getDeviceID() != 0  && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getDeviceID() != 0  && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null && dc2.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }












        else if (d2.getMacadd() != null  && d2.getFirmNum() != 0  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getMacadd() != null && d2.getFirmNum() != 0  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getMacadd() != null && d2.getFirmNum() != 0  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null && dc2.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }



        else if (d2.getMacadd() != null && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getMacadd() != null && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getMacadd() != null && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null && dc2.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getFirmNum() != 0  && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getFirmNum() != 0 && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getFirmNum() != 0  && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null && dc2.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }


        else if (d2.getDeviceID() != 0 && d2.getFirmNum() != 0 && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getFirmNum() != 0 && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getFirmNum() != 0 && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }



        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }



        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0   && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0  && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0  &&  d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true  ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }














        ////////////////////////////////////////2 level /////////////////////////////////////////////////


        else if (d2.getDeviceID() != 0 && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if (d2.getMacadd() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if ( d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }
        else if (d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }




        else if (d2.getDeviceID() != 0 && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null  && d2.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if (d2.getMacadd() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null  && d2.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if ( d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null  && d2.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }
        else if (d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }






        else if (d2.getDeviceID() != 0 && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null && dc2.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if (d2.getMacadd() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null && dc2.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if ( d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null && dc2.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }
        else if (d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getValidity() == true && d2.getPublicKey() != null && dc2.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

















        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d2.getDeviceID() != 0 && d2.getFirmVendor() != null && d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d2.getMacadd() != null && d2.getFirmVendor() != null && d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmVendor() != null && dc2.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d2.getDeviceID() != 0 && d2.getFirmVendor() != null && d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d2.getMacadd() != null && d2.getFirmVendor() != null && d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null  && dc2.getDateOfIssue() != null && dc2.getSignAlgo() != null ) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d2.getDeviceID() != 0 &&  d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d2.getDeviceID() != 0 &&  d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null && dc2.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d2.getMacadd() != null && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d2.getMacadd() != null && d2.getFirmNum() != 0   && dc2.getDateOfIssue() != null && dc2.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d2.getFirmVendor() != null && d2.getFirmNum() != 0   && dc2.getDateOfIssue() != null && dc2.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }


        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null  && dc2.getDateOfIssue() != null && dc2.getSerialNumber() != 0 ) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d2.getDeviceID() != 0 &&  d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && dc2.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d2.getDeviceID() != 0 &&  d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null && dc2.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d2.getMacadd() != null && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && dc2.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d2.getMacadd() != null && d2.getFirmNum() != 0   && dc2.getDateOfIssue() != null && dc2.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d2.getFirmVendor() != null && d2.getFirmNum() != 0   && dc2.getDateOfIssue() != null && dc2.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }





        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null  && dc2.getDateOfIssue() != null && d2.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d2.getDeviceID() != 0 &&  d2.getFirmVendor() != null && dc2.getDateOfIssue() != null && d2.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d2.getDeviceID() != 0 &&  d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null && d2.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d2.getMacadd() != null && d2.getFirmVendor() != null  && dc2.getDateOfIssue() != null && d2.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d2.getMacadd() != null && d2.getFirmNum() != 0   && dc2.getDateOfIssue() != null && d2.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d2.getFirmVendor() != null && d2.getFirmNum() != 0   && dc2.getDateOfIssue() != null && d2.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }///////////////////////// level 1 ///////////////////////////////

        else if (d2.getDeviceID() != 0 && dc2.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");}
        else if (d2.getMacadd() != null && dc2.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");}
        else if ( d2.getFirmNum() != 0 && dc2.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");
        }
        else if (d2.getFirmVendor() != null && dc2.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");
        }


        else if ( dc2.getSignAlgo() != null  && dc2.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");}
        else if ( dc2.getSerialNumber() != 0 && dc2.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");}
        else if ( d2.getPublicKey() != null && dc2.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");
        }

        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null     && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null     && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getDeviceID() != 0 && d2.getFirmNum() != 0 && d2.getFirmVendor() != null     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmVendor() != null     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");







        } else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }


        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null     && dc2.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null     && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0 && d2.getFirmVendor() != null     && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getFirmNum() != 0 && d2.getFirmVendor() != null     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getDeviceID() != 0 && d2.getFirmVendor() != null     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getDeviceID() != 0 && d2.getFirmNum() != 0     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }


        else if (d2.getMacadd ()!= null && d2.getFirmNum() != 0     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }



        else if (d2.getMacadd()!= null && d2.getFirmNum() != 0     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0 && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null      && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null      && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null      && d2.getPublicKey() != null && dc2.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }





        else if (d2.getDeviceID() != 0  && d2.getFirmNum() != 0      && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0  && d2.getFirmNum() != 0      && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0  && d2.getFirmNum() != 0      && d2.getPublicKey() != null && dc2.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }



        else if (d2.getDeviceID() != 0  && d2.getFirmVendor() != null      && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0  && d2.getFirmVendor() != null      && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getFirmVendor() != null      && d2.getPublicKey() != null && dc2.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d2.getMacadd() != null  && d2.getFirmNum() != 0      && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getMacadd() != null && d2.getFirmNum() != 0      && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getMacadd() != null && d2.getFirmNum() != 0      && d2.getPublicKey() != null && dc2.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d2.getMacadd() != null && d2.getFirmVendor() != null      && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getMacadd() != null && d2.getFirmVendor() != null      && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getMacadd() != null && d2.getFirmVendor() != null      && d2.getPublicKey() != null && dc2.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getFirmNum() != 0  && d2.getFirmVendor() != null      && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getFirmNum() != 0 && d2.getFirmVendor() != null      && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getFirmNum() != 0  && d2.getFirmVendor() != null      && d2.getPublicKey() != null && dc2.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if (d2.getMacadd() != null     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d2.getFirmNum() != 0     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getFirmVendor() != null     && dc2.getSignAlgo() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0     && dc2.getSignAlgo() != null  && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if (d2.getMacadd() != null     && dc2.getSignAlgo() != null  && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d2.getFirmNum() != 0     && dc2.getSignAlgo() != null  && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getFirmVendor() != null     && dc2.getSignAlgo() != null && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0     && d2.getPublicKey() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if (d2.getMacadd() != null     && d2.getPublicKey() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d2.getFirmNum() != 0     && d2.getPublicKey() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getFirmVendor() != null     && d2.getPublicKey() != null && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmVendor() != null  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getDeviceID() != 0 && d2.getFirmVendor() != null && d2.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getMacadd() != null && d2.getFirmVendor() != null && d2.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d2.getDeviceID() != 0 && d2.getMacadd() != null && d2.getFirmVendor() != null  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getDeviceID() != 0 && d2.getFirmVendor() != null && d2.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getMacadd() != null && d2.getFirmVendor() != null && d2.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null    && dc2.getSignAlgo() != null ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d2.getDeviceID() != 0 &&  d2.getFirmVendor() != null   && dc2.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getDeviceID() != 0 &&  d2.getFirmNum() != 0   && dc2.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getMacadd() != null && d2.getFirmVendor() != null    && dc2.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d2.getMacadd() != null && d2.getFirmNum() != 0     && dc2.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d2.getFirmVendor() != null && d2.getFirmNum() != 0     && dc2.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null    && dc2.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d2.getDeviceID() != 0 &&  d2.getFirmVendor() != null   && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getDeviceID() != 0 &&  d2.getFirmNum() != 0   && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getMacadd() != null && d2.getFirmVendor() != null    && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d2.getMacadd() != null && d2.getFirmNum() != 0     && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d2.getFirmVendor() != null && d2.getFirmNum() != 0     && dc2.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0 && d2.getMacadd() != null    && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d2.getDeviceID() != 0 &&  d2.getFirmVendor() != null   && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getDeviceID() != 0 &&  d2.getFirmNum() != 0   && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d2.getMacadd() != null && d2.getFirmVendor() != null    && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d2.getMacadd() != null && d2.getFirmNum() != 0     && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d2.getFirmVendor() != null && d2.getFirmNum() != 0     && d2.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d2.getDeviceID() != 0   ) {
            T1 = 0;
            System.out.println("Level 0 Trust");}
        else if (d2.getMacadd() != null   ) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d2.getFirmNum() != 0   ) {
            T1 = 0;
            System.out.println("Level 0 Trust");
        }
        else if (d2.getFirmVendor() != null   ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }


        else if ( dc2.getSignAlgo() != null    ) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( dc2.getSerialNumber() != 0   ) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d2.getPublicKey() != null   ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }



        randomnum r2 = new randomnum();
        int x2 = r2.randomint(0, T2);
        // System.out.println(" Random value for A  " + x2);


        ////////////////////////////// third device attributes list //////////////////
        Scanner scanner5 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);

        System.out.println(" how many attributes you have FOR DEVICE C ");

        int num2 = scanner5.nextInt();
        int k2 = 0;
        String[] keep2 = new String[num2];

        DeviceAttribute d3 = new DeviceAttribute();
        DeviceCertificate dc3 = new DeviceCertificate();
        DeviceStatus ds3 = new DeviceStatus();

        for (int K = 1; K < num2 + 1; K++) {

            System.out.println(" Enter Key of " + K + " attributes you have for DEVICE 3 ");
            String numatt3 = scanner4.next();

            keep2[k2] = numatt3;
            k2++;
            switch (numatt3) {

                case "oda1":
                    System.out.println("Enter Device Name:MAX = 10 char");
                    String device_name3 = scanner4.next();
                    while (device_name3.length() > 10) {
                        System.out.println("Too long name ");
                        device_name3 = scanner4.next();

                    }
                    d3.setName(device_name3);
                    System.out.println("Accepted");
                    break;

                case "oda4":
                    System.out.println("Enter Device Description MAX =20 char");
                    String desc3 = scanner4.next();
                    while (desc3.length() > 20) {
                        System.out.println("description is too long");
                        desc3 = scanner4.next();
                    }
                    d3.setDesc(desc3);
                    System.out.println("Accepted");
                    break;


                case "da1":
                    System.out.println("Enter Device ID:MAX 3 digit ");
                    int id3 = scanner4.nextInt();
                    while (id3 > 999) {
                        System.out.println("device id is too long enter again");
                        id3 = scanner4.nextInt();

                    }
                    d3.setDeviceID(id3);
                    System.out.println("Accepted");
                    break;


                case "da2":
                    System.out.println("Enter Physical address (Mac address) length= 12  ");
                    String macadd3 = scanner4.next();
                    while (macadd3.length() != 12) {
                        System.out.println("Too long mac address");
                        macadd3 = scanner4.next();
                    }
                    d3.setMacadd(macadd3);
                    System.out.println("Accepted");
                    break;

                case "da4":
                    System.out.println("Enter Firmware Vendor MAX = 8 char");
                    String firmwareVendor3 = scanner4.next();
                    while (firmwareVendor3.length() > 8) {
                        System.out.println("too long vendor name");
                        firmwareVendor3 = scanner4.next();
                    }
                    d3.setFirmVendor(firmwareVendor3);
                    System.out.println("Accepted");
                    break;
                case "da3":

                    System.out.println("Enter Firmware Version");
                    double firmNum3 = scanner4.nextDouble();

                    d3.setFirmNum(firmNum3);
                    break;


                case "dc3":
                    System.out.println("Enter device public key MAX = 10  ");
                    String publickey3 = scanner4.next();
                    while (publickey3.length() != 10) {
                        System.out.println("out of range");
                        publickey3 = scanner4.next();

                    }
                    d3.setPublicKey(publickey3);
                    System.out.println("Accepted");
                    break;


                case "oda5":
                    System.out.println("Enter Hardware Version");
                    float hardwareVersion3 = scanner4.nextFloat();
                    d3.setHardwareVersion(hardwareVersion3);
                    System.out.println("Accepted");
                    break;

                case "oda2":
                    System.out.println("Enter Device Serial Number MAX = 5 digits");
                    int serialNumber3 = scanner4.nextInt();
                    while (serialNumber3 > 99999) {
                        System.out.println("out of range ");
                        serialNumber3 = scanner4.nextInt();
                    }
                    d3.setSerialNumber(serialNumber3);
                    System.out.println("Accepted");
                    break;


                ////////////Device status
                //System.out.println("Device Status");


                case "on":
                    System.out.println("Device On");
                    boolean isOn3 = scanner4.nextBoolean();
                    ds3.setOn(isOn3);
                    break;

                case "cf":
                    System.out.println("Device Configured");
                    boolean isConfigured3 = scanner4.nextBoolean();
                    ds3.setIsconfigured(isConfigured3);
                    break;


                ///////////Device certificate

                // System.out.println("Details about Digital certificate");


                case "oca1":
                    System.out.println("Enter issuer authority name MAX =10 char");
                    String issuer3 = scanner4.next();
                    while (issuer3.length() != 10) {
                        System.out.println("try again out of range ");
                        issuer3 = scanner4.next();
                    }
                    dc3.setIssuer(issuer3);
                    System.out.println("Accepted");
                    break;

                case "dc1":
                    System.out.println("Enter serial number MAX= 5 digit");
                    int sernum3 = scanner4.nextInt();
                    while (sernum3 > 99999) {
                        System.out.println("Serial num is too long try again");
                        sernum3 = scanner4.nextInt();

                    }
                    dc3.setSerialNumber(sernum3);
                    System.out.println("Accepted");
                    break;

                case "dc2":
                    System.out.println("Enter digital signature length=12 ");
                    String signalgo3 = scanner4.next();
                    while (signalgo3.length() != 12) {

                        System.out.println(" too long try again ");
                        signalgo3 = scanner4.next();
                    }
                    dc3.setSignAlgo(signalgo3);
                    System.out.println("Accepted");
                    break;

                case "def":

                    System.out.println("Enter the date of issue MM/dd/yyyy");

                    String expectedPattern = "MM/dd/yyyy";
                    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
                    try {
                        // (2) give the formatter a String that matches the SimpleDateFormat pattern
                        String date2 = scanner4.next();
                        Date date = formatter.parse(date2);

                        dc3.setDateOfIssue(date);
                    } catch (ParseException e) {
                        // execution will come here if the String that is given
                        // does not match the expected format.
                        e.printStackTrace();
                    }
                    System.out.println("Enter validity status");
                    boolean validity2 = scanner4.nextBoolean();
                    dc3.setValidity(validity2);
                    System.out.println("Accepted");
                    break;


            }

        }

        System.out.println("device C attributes list number" + Arrays.toString(keep2));


///////////////////////////Personal attributes for device 3 CHECK /////////////////

        System.out.println("DEVICE C personal trust level");
        if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 5;
            System.out.println("Level 5 Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d3.getDeviceID() != 0 && d3.getFirmNum() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");







        } else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }


        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }

        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSerialNumber() != 0) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d3.getFirmNum() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d3.getDeviceID() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        } else if (d3.getDeviceID() != 0 && d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }

        else if (d3.getMacadd() != null && d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }



        else if (d3.getMacadd() != null && d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 4;
            System.out.println("Level 4 Trust");
        }


        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null && dc3.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }





        else if (d3.getDeviceID() != 0  && d3.getFirmNum() != 0  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getDeviceID() != 0  && d3.getFirmNum() != 0  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getDeviceID() != 0  && d3.getFirmNum() != 0  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null && dc3.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }



        else if (d3.getDeviceID() != 0  && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getDeviceID() != 0  && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null && dc3.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }












        else if (d3.getMacadd() != null  && d3.getFirmNum() != 0  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getMacadd() != null && d3.getFirmNum() != 0  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getMacadd() != null && d3.getFirmNum() != 0  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null && dc3.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }



        else if (d3.getMacadd() != null && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getMacadd() != null && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getMacadd() != null && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null && dc3.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getFirmNum() != 0  && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getFirmNum() != 0 && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getFirmNum() != 0  && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null && dc3.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }


        else if (d3.getDeviceID() != 0 && d3.getFirmNum() != 0 && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getFirmNum() != 0 && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getFirmNum() != 0 && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }



        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }



        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0   && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSerialNumber() != 0 ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0  && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0  &&  d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true  ) {
            T1 = 3;
            System.out.println("Level 3 Trust");
        }


















        ////////////////////////////////////////2 level /////////////////////////////////////////////////


        else if (d3.getDeviceID() != 0 && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if (d3.getMacadd() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if ( d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }
        else if (d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }




        else if (d3.getDeviceID() != 0 && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null  && d3.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if (d3.getMacadd() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null  && d3.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if ( d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null  && d3.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }
        else if (d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }






        else if (d3.getDeviceID() != 0 && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null && dc3.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if (d3.getMacadd() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null && dc3.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");}
        else if ( d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null && dc3.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }
        else if (d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getValidity() == true && d3.getPublicKey() != null && dc3.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

















        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d3.getDeviceID() != 0 && d3.getFirmVendor() != null && d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d3.getMacadd() != null && d3.getFirmVendor() != null && d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmVendor() != null && dc3.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d3.getDeviceID() != 0 && d3.getFirmVendor() != null && d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d3.getMacadd() != null && d3.getFirmVendor() != null && d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null  && dc3.getDateOfIssue() != null && dc3.getSignAlgo() != null ) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d3.getDeviceID() != 0 &&  d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d3.getDeviceID() != 0 &&  d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null && dc3.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d3.getMacadd() != null && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d3.getMacadd() != null && d3.getFirmNum() != 0   && dc3.getDateOfIssue() != null && dc3.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d3.getFirmVendor() != null && d3.getFirmNum() != 0   && dc3.getDateOfIssue() != null && dc3.getSignAlgo() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }


        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null  && dc3.getDateOfIssue() != null && dc3.getSerialNumber() != 0 ) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d3.getDeviceID() != 0 &&  d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && dc3.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d3.getDeviceID() != 0 &&  d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null && dc3.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d3.getMacadd() != null && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && dc3.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d3.getMacadd() != null && d3.getFirmNum() != 0   && dc3.getDateOfIssue() != null && dc3.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d3.getFirmVendor() != null && d3.getFirmNum() != 0   && dc3.getDateOfIssue() != null && dc3.getSerialNumber() != 0) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }





        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null  && dc3.getDateOfIssue() != null && d3.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }else if (d3.getDeviceID() != 0 &&  d3.getFirmVendor() != null && dc3.getDateOfIssue() != null && d3.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d3.getDeviceID() != 0 &&  d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null && d3.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        } else if (d3.getMacadd() != null && d3.getFirmVendor() != null  && dc3.getDateOfIssue() != null && d3.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d3.getMacadd() != null && d3.getFirmNum() != 0   && dc3.getDateOfIssue() != null && d3.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }

        else if (d3.getFirmVendor() != null && d3.getFirmNum() != 0   && dc3.getDateOfIssue() != null && d3.getPublicKey() != null) {
            T1 = 2;
            System.out.println("Level 2 Trust");
        }///////////////////////// level 1 ///////////////////////////////

        else if (d3.getDeviceID() != 0 && dc3.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");}
        else if (d3.getMacadd() != null && dc3.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");}
        else if ( d3.getFirmNum() != 0 && dc3.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");
        }
        else if (d3.getFirmVendor() != null && dc3.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");
        }


        else if ( dc3.getSignAlgo() != null  && dc3.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");}
        else if ( dc3.getSerialNumber() != 0 && dc3.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");}
        else if ( d3.getPublicKey() != null && dc3.getDateOfIssue() != null ) {
            T1 = 1;
            System.out.println("Level 1  Trust");
        }

        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null     && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null     && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getDeviceID() != 0 && d3.getFirmNum() != 0 && d3.getFirmVendor() != null     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmVendor() != null     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");







        } else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }


        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null     && dc3.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null     && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0 && d3.getFirmVendor() != null     && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getFirmNum() != 0 && d3.getFirmVendor() != null     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getDeviceID() != 0 && d3.getFirmVendor() != null     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getDeviceID() != 0 && d3.getFirmNum() != 0     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }


        else if (d3.getMacadd ()!= null && d3.getFirmNum() != 0     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }



        else if (d3.getMacadd()!= null && d3.getFirmNum() != 0     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0 && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null      && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null      && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null      && d3.getPublicKey() != null && dc3.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }





        else if (d3.getDeviceID() != 0  && d3.getFirmNum() != 0      && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0  && d3.getFirmNum() != 0      && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0  && d3.getFirmNum() != 0      && d3.getPublicKey() != null && dc3.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }



        else if (d3.getDeviceID() != 0  && d3.getFirmVendor() != null      && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0  && d3.getFirmVendor() != null      && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getFirmVendor() != null      && d3.getPublicKey() != null && dc3.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d3.getMacadd() != null  && d3.getFirmNum() != 0      && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getMacadd() != null && d3.getFirmNum() != 0      && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getMacadd() != null && d3.getFirmNum() != 0      && d3.getPublicKey() != null && dc3.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d3.getMacadd() != null && d3.getFirmVendor() != null      && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getMacadd() != null && d3.getFirmVendor() != null      && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getMacadd() != null && d3.getFirmVendor() != null      && d3.getPublicKey() != null && dc3.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getFirmNum() != 0  && d3.getFirmVendor() != null      && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getFirmNum() != 0 && d3.getFirmVendor() != null      && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getFirmNum() != 0  && d3.getFirmVendor() != null      && d3.getPublicKey() != null && dc3.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if (d3.getMacadd() != null     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d3.getFirmNum() != 0     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getFirmVendor() != null     && dc3.getSignAlgo() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0     && dc3.getSignAlgo() != null  && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if (d3.getMacadd() != null     && dc3.getSignAlgo() != null  && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d3.getFirmNum() != 0     && dc3.getSignAlgo() != null  && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getFirmVendor() != null     && dc3.getSignAlgo() != null && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0     && d3.getPublicKey() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if (d3.getMacadd() != null     && d3.getPublicKey() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d3.getFirmNum() != 0     && d3.getPublicKey() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getFirmVendor() != null     && d3.getPublicKey() != null && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmVendor() != null  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getDeviceID() != 0 && d3.getFirmVendor() != null && d3.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getMacadd() != null && d3.getFirmVendor() != null && d3.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d3.getDeviceID() != 0 && d3.getMacadd() != null && d3.getFirmVendor() != null  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getDeviceID() != 0 && d3.getFirmVendor() != null && d3.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getMacadd() != null && d3.getFirmVendor() != null && d3.getFirmNum() != 0  ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null    && dc3.getSignAlgo() != null ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d3.getDeviceID() != 0 &&  d3.getFirmVendor() != null   && dc3.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getDeviceID() != 0 &&  d3.getFirmNum() != 0   && dc3.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getMacadd() != null && d3.getFirmVendor() != null    && dc3.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d3.getMacadd() != null && d3.getFirmNum() != 0     && dc3.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d3.getFirmVendor() != null && d3.getFirmNum() != 0     && dc3.getSignAlgo() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null    && dc3.getSerialNumber() != 0 ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d3.getDeviceID() != 0 &&  d3.getFirmVendor() != null   && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getDeviceID() != 0 &&  d3.getFirmNum() != 0   && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getMacadd() != null && d3.getFirmVendor() != null    && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d3.getMacadd() != null && d3.getFirmNum() != 0     && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d3.getFirmVendor() != null && d3.getFirmNum() != 0     && dc3.getSerialNumber() != 0) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0 && d3.getMacadd() != null    && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }else if (d3.getDeviceID() != 0 &&  d3.getFirmVendor() != null   && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getDeviceID() != 0 &&  d3.getFirmNum() != 0   && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        } else if (d3.getMacadd() != null && d3.getFirmVendor() != null    && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d3.getMacadd() != null && d3.getFirmNum() != 0     && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }

        else if (d3.getFirmVendor() != null && d3.getFirmNum() != 0     && d3.getPublicKey() != null) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }
        else if (d3.getDeviceID() != 0   ) {
            T1 = 0;
            System.out.println("Level 0 Trust");}
        else if (d3.getMacadd() != null   ) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d3.getFirmNum() != 0   ) {
            T1 = 0;
            System.out.println("Level 0 Trust");
        }
        else if (d3.getFirmVendor() != null   ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }


        else if ( dc3.getSignAlgo() != null    ) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( dc3.getSerialNumber() != 0   ) {
            T1 = 0;
            System.out.println("Level 0  Trust");}
        else if ( d3.getPublicKey() != null   ) {
            T1 = 0;
            System.out.println("Level 0  Trust");
        }




        //////////////// SHARED PROTOCOLS BETWEEN DEVICES  ////////////////////////////





        boolean di12 = false;
        boolean di21 = false;
        boolean di23 = false;
        boolean di32 = false;
        boolean di13 = false;
        boolean di31 = false;

/////////////////////////////////////////////////////////RECOMMANDATION ////////////////////////////////
        System.out.println("Device A Do you want communicate with anyone ? ");
        String interact = scanner.next();
        ds1.setInteracted(interact);
        if (interact.equals("yes")) {
            System.out.println("is it with device B ?");
            di12 = scanner.nextBoolean();
            if (di12 == true) {
                ds1.setIsconfigured12(di12);
                int ATFB = T1;
                System.out.println(" device A willing to establish trust relations with device B");

            }
            System.out.println("is it with device C ?");
            di13 = scanner.nextBoolean();
            if (di13 == true) {
                int ATFC = T1;
                ds1.setIsconfigured13(di13);
                System.out.println(" device A willing to establish trust relations with device C ");
            }

        } else {
            System.out.println(" device A does not want to interacted with anyone");
        }

        System.out.println("Device B Do you want communicate with anyone ?");
        String interact1 = scanner2.next();
        ds2.setInteracted(interact1);
        if (interact1.equals("yes")) {
            System.out.println(" is it with device A ?");
            di21 = scanner2.nextBoolean();
            if (di21 == true) {
                int BTFA = T2;
                ds2.setIsconfigured21(di21);
                System.out.println(" device B willing to establish trust relations with device A ");
            }
            System.out.println(" is it with device C ?");
            di23 = scanner2.nextBoolean();
            if (di23 == true) {
                int BTFC = T2;
                ds2.setIsconfigured23(di23);
                System.out.println(" device B willing to establish trust relations with device C ");
            }
        } else {
            System.out.println(" device B does not want to interacted with anyone ? ");
        }


        System.out.println("Device C Do you communicate with anyone");
        String interact2 = scanner4.next();
        ds3.setInteracted(interact2);
        if (interact2.equals("yes")) {
            System.out.println(" is it with device A ?");
            di31 = scanner4.nextBoolean();
            if (di31 == true) {
                int CTFA = T3;
                ds3.setIsconfigured31(di31);
                System.out.println(" device C willing to establish trust relations with device A");


            }
            System.out.println(" is it with device B ?");
            di32 = scanner4.nextBoolean();
            if (di32 == true) {
                int CTFB = T3;
                ds3.setIsconfigured32(di32);
                System.out.println(" device C willing to establish trust relations with device B ");
            }
        } else {
            System.out.println(" device C does not want interacted with anyone");
        }

        //////////////////////////////////////////////////////////////////////////////////////////// Real Recommandations //////
        int[] davg = new int[0];

        int[] recom = new int[3];

        int recom1 = 0;
        int rr1 = 0;
        int rr2 = 0;
        int rr3 = 0;


        int rrr1 = 0;
        int rrr2 = 0;
        int rrr3 = 0;


        int b1 = 0;
        int a1 = 0;
        int c1 = 0;

        int b = 0;
        int a = 0;
        int c = 0;
        System.out.println("Device A personal trust");
        int t1 = scanner.nextInt();

        System.out.println("Device B personal trust");
        int t2 = scanner.nextInt();

        System.out.println("Device C personal trust");
        int t3 = scanner.nextInt();

        int asb = 0;
        int ahb = 0;
        int aub = 0;
        int abu = 0;

        int bsa = 0;
        int bha = 0;
        int bua = 0;
        int bau = 0;


        int bsc = 0;
        int bhc = 0;
        int buc = 0;
        int bcu = 0;

        int csb = 0;
        int chb = 0;
        int cub = 0;
        int cbu = 0;


        int csa = 0;
        int cha = 0;
        int cua = 0;
        int cau = 0;

        int asc = 0;
        int ahc = 0;
        int auc = 0;
        int acu = 0;

        int noiab = 0;
        int noiba = 0;
        int noibc = 0;
        int noicb = 0;
        int noiac = 0;
        int noica = 0;


        randomnum r3 = new randomnum();
        int x3 = r3.randomint(0, T3);
        int x4;
        // System.out.println(" Random value for A  " + x3);
        System.out.println("How many times devices should interact with each others ");
        int inter = scanner.nextInt();
        int[] asb1 = new int[inter];
        int[] bsa1 = new int[inter];
        int[] bsc1 = new int[inter];

        int[] csb1 = new int[inter];
        int[] csa1 = new int[inter];
        int[] asc1 = new int[inter];

        System.out.println("Device A,B,C has begin interaction with each other using their personal trust level. " +
                "They have  "+ inter +" chances to establish trust relations with each other ");


        if (di12 == true && di21 == true) {

            for (int i = 0; i < inter; i++) {

                x = r3.randomint(1, 5); //A
                x2 = r3.randomint(1, 5); // B


                //  bavg[b] = x2;
                b++;


                if (t1 > x && x2 < t1) {
                    asb1[asb] = x2;
                    asb++;
                }
                if (t1 == x && x2 <= t1) {

                    ahb++;
                }
                if (t1 < x && x2 <= t1) {

                    aub++;
                }
                if (t1 < x && x2 > t1) {

                    abu++;
                }
                if ((t1 > x && x2 < t1) != true && (t1 == x && x2 <= t1) != true && (t1 < x && x2 <= t1) != true && (t1 < x && x2 > t1) != true) {
                    noiab++;
                }


            }
        }




        if (di12 == true && di21 == true) {

            for (int i = 0; i < inter; i++) {

                x = r3.randomint(1, 5); //A
                x2 = r3.randomint(1, 5); // B

                //bsa1[bsa] = x2;
                //a++;

                //bavg[b] = x2;
                //b++;

                if (t2 > x2 && x < t2) {
                    bsa1[bsa] = x;
                    bsa++;
                }
                if (t2 == x2 && x <= t2) {

                    bha++;
                }
                if (t2 < x2 && x <= t2) {

                    bua++;
                }
                if (t2 < x2 && x > t2) {

                    bau++;
                }
                if ((t2 > x2 && x < t2) != true && (t2 == x2 && x <= t2) != true && (t2 < x2 && x <= t2) != true && (t2 < x2 && x > t2) != true) {
                    noiba++;
                }


            }
        }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////



        if (di23 == true && di32 == true) {

            for (int i = 0; i < inter; i++) {

                x3 = r3.randomint(1, 5); //C
                x2 = r3.randomint(1, 5); // B

                //aavg[a] = x3;
                //a++;

                //bavg[b] = x2;
                //b++;

                if (t2 > x2 && x3 < t2) {
                    bsc1[bsc] = x3;
                    bsc++;
                }
                if (t2 == x2 && x3 <= t2) {

                    bhc++;
                }
                if (t2 < x2 && x3 <= t2) {

                    buc++;
                }
                if (t2 < x2 && x3 > t2) {

                    bcu++;
                }
                if ((t2 > x2 && x3 < t2) != true && (t2 == x2 && x3 <= t2) != true && (t2 < x2 && x3 <= t2) != true && (t2 < x2 && x3 > t2) != true) {
                    noibc++;
                }


            }


        }




        if (di23 == true && di32 == true) {

            for (int i = 0; i < inter; i++) {

                x3 = r3.randomint(1, 5); //C
                x2 = r3.randomint(1, 5); // B

                //aavg[a] = x3;
                //a++;

                //bavg[b] = x3;
                //b++;

                if (t3 > x3 && x2 < t3) {
                    csb1[csb] = x2;

                    csb++;
                }
                if (t3 == x3 && x2 <= t3) {

                    chb++;
                }
                if (t3 < x3 && x2 <= t3) {

                    cub++;
                }
                if (t3 < x3 && x2 > t3) {

                    cbu++;
                }
                if ((t3 > x3 && x2 < t3) != true && (t3 == x3 && x2 <= t3) != true && (t3 < x3 && x2 <= t3) != true && (t3 < x3 && x2 > t3) != true) {
                    noicb++;
                }


            }


        }

        //////////////////////////////////////////////////////////////////////////////////////////////


        if (di31 == true && di13 == true) {


            for (int i = 0; i < inter; i++) {

                x3 = r3.randomint(1, 5); //c
                x = r3.randomint(1, 5); // A

                //aavg[a] = x;
                //a++;

                //bavg[b] = x;
                //b++;

                if (t1 > x && x3 < t1) {
                    asc1[asc] = x3;
                    asc++;
                }
                if (t1 == x && x3 <= t1) {

                    ahc++;
                }
                if (t1 < x && x3 <= t1) {

                    auc++;
                }
                if (t1 < x && x3 > t1) {

                    acu++;
                }
                if ((t1 > x && x3 < t1) != true && (t1 == x && x3 <= t1) != true && (t1 < x && x3 <= t1) != true && (t1 < x && x3 > t1) != true) {
                    noiac++;
                }


            }


        }



        if (di31 == true && di13 == true) {

            for (int i = 0; i < inter; i++) {

                x3 = r3.randomint(1, 5); //C
                x = r3.randomint(1, 5); // A

                //aavg[a] = x;
                //a++;

                //bavg[b] = x;
                //b++;

                if (t3 > x3 && x < t3) {
                    csa1[csa] = x;
                    csa++;
                }
                if (t3 == x3 && x <= t3) {

                    cha++;
                }
                if (t3 < x3 && x <= t3) {

                    cua++;
                }
                if (t3 < x3 && x > t3) {

                    cau++;
                }
                if ((t3 > x3 && x < t3) != true && (t3 == x3 && x <= t3) != true && (t3 < x3 && x <= t3) != true && (t3 < x3 && x > t3) != true) {
                    noica++;
                }


            }


        }
        System.out.println(" Device A has begun the interaction with Device B ");
        System.out.println(" ===========A ==(Trusted agent)=========================== B ====== (Trusting agent)==================================================");

        System.out.println("Device A serving Device B's request   ... asb   " + asb);
        System.out.println("Device A is being honest and serving Device B's request ... ahb    " + ahb);

        System.out.println("Device A is being untrustworthy to Device B's request .... aub   " + aub);
        System.out.println("Device A and Device B both are being untrustworthy ........abu   " + abu);

        System.out.println(" Number of unattended interactions ...." + noiab);

        System.out.println("Device B has begun the interaction with Device A ");
        System.out.println(" ===========B ====(Trusted agent)========================= A ===== (Trusting agent) ===================================================");
        System.out.println("Device B is serving Device A's request   ... bsa   " + bsa);
        System.out.println("Device B is being honest and serving Device A's request ... bha    " + bha);

        System.out.println("Device B is being untrustworthy to Device A's request .... bua   " + bua);

        System.out.println("Device A and Device B both are being untrustworthy ........bau   " + bau);

        System.out.println(" Number of unattended interactions ...." + noiba);

        System.out.println("Device B has begun the interaction with Device C ");
        System.out.println(" ============B ===(Trusted agent)================================= C====(Trusting agent)============================================");
        System.out.println("Device B is serving Device C 's request  ... bsc   " + bsc);
        System.out.println("Device B is being honest and serving Device C's request ... bhc    " + bhc);

        System.out.println("Device B is being untrustworthy to Device C's request .... buc   " + buc);

        System.out.println("Device B and Device C  both are being untrustworthy ........bcu   " + bcu);
        System.out.println(" Number of unattended interactions ...." + noibc);

        System.out.println("Device C has begun the interaction with Device B ");
        System.out.println(" ===================C ====(Trusted agent)=============================== B ====(Trusting agent)======================================");
        System.out.println("Device C is serving Device B 's request  ... csb   " + csb);
        System.out.println("Device C is being honest and serving Device B's request ... chb    " + chb);

        System.out.println("Device C is being untrustworthy to Device B 's request .... cub   " + cub);

        System.out.println("Device C and Device B both are being untrustworthy ........cbu   " + cbu);
        System.out.println(" Number of unattended interactions .... " + noicb);

        System.out.println("Device A has begun the interaction with Device C ");
        System.out.println(" ==============A =====(Trusted agent)=========================== C ===(Trusting agent)===============================================");
        System.out.println("Device A is serving Device C 's request  ... asc   " + asc);
        System.out.println("Device A is being honest and serving Device C 's request ... ahc   " + ahc);

        System.out.println("Device A is being untrustworthy to Device C 's request .... auc   " + auc);

        System.out.println("Device A and Device C  both are being untrustworthy ........acu   " + acu);
        System.out.println(" Number of unattended interactions ...." + noiac);

        System.out.println("Device C has begun the interaction with Device A ");
        System.out.println(" ================= C ====(Trusted agent)============================ A =====(Trusting agent)==========================================");
        System.out.println("Device C is serving Device A's request  ... csa   " + csa);
        System.out.println("Device C is being honest and serving Device A's request ... cha    " + cha);

        System.out.println("Device C is being untrustworthy to Device A's request .... cua   " + cua);

        System.out.println("Device C and Device A both are being untrustworthy ........cau   " + cau);
        System.out.println(" Number of unattended interactions ...." + noica);


        // if (asb != 0 && bsa != 0 && bsc != 0 && csb != 0 && asc != 0 && csa != 0) {

           /* int sumAB = IntStream.of(asb1).sum() / asb;
            int sumBA = IntStream.of(bsa1).sum() / bsa;
            int sumBC = IntStream.of(bsc1).sum() / bsc;
            int sumCB = IntStream.of(csb1).sum() / csb;
            int sumAC = IntStream.of(asc1).sum() / asc;
            int sumCA = IntStream.of(csa1).sum() / csa;
            */


        int AH;
        int BH;
        int CH;
        AH = ahb + ahc;
        BH = bha + bhc;
        CH = cha + chb;

        int ABH = ahb + asb;
        int BAH = bha + bsa;
        int BCH = bhc + bsc;
        int CBH = csb + chb;
        int ACH = asc + ahc;
        int CAH = csa + cha;

        int TAB = ABH + aub + abu;
        int TBA = BAH + bua + bau;
        int TBC = BCH + buc + bcu;
        int TCB = CBH + cub + cbu;
        int TAC = ACH + auc + acu;
        int TCA = CAH + cua + cau;


        System.out.println(" BASED ON PREVIOUS INTERACTIONS ");
        System.out.println("===========================================================================================================================");
        System.out.println(" During interaction Device A was being honest "+ ahb +"  times  with Device B  "+ ahc +" times with and C" + " total honest interactions done by A = " + AH);
        System.out.println("=================================================================================================================================================================");

        System.out.println(" During interaction Device B was being honest "+ bha +"  times  with Device A  "+ bhc +" times with and C" + " total honest interactions done by B = " + BH);
        System.out.println("=========================================================================================================================================================================");

        System.out.println(" During interaction Device C was being honest "+ cha +"  times  with Device A  "+ chb +" times with and B" + " total honest interactions done by C = " + CH);
        System.out.println("=================================================================================================================================================================");

        System.out.println(" Whoever has highest number of honest interactions with others will be selected as a Recommender Node for other participant nodes");

        System.out.println("****************************************************************************************************************************************************************");
        if (AH > BH && AH > CH) {

            System.out.println("Device A has become RECOMMENDER node FOR B AND C ");
            System.out.println("==========================================================================================================================================================");

            //System.out.println(sumAB);
            System.out.println(" A's as (trustee) trustworthiness towards B is (trusted) =  " + (float) BAH / TBA * 100 + "%");

            // System.out.println(sumAC);
            System.out.println(" A's as (trustee) trustworthiness towards C is (trusted) = " + (float) CAH / TCA * 100 + "%");
        } else if (AH < BH && BH > CH) {

            System.out.println(" Device B has become RECOMMENDER node FOR C AND A  ");
            System.out.println("=============================================================================================================================================================");

            // System.out.println(sumBA);
            System.out.println(" B 's as (trustee) trustworthiness towards A is (trusted) =  " + (float) ABH / TAB * 100 + "%");

            //System.out.println(sumBC);
            System.out.println(" B 's as (trustee) trustworthiness towards C is (trusted) =   " + (float) CBH / TCB * 100 + "%");


        } else if (CH > AH && BH < CH) {

            System.out.println("Device C is has become RECOMMENDER node FOR B AND A ");
            System.out.println("================================================================================================================================================================");

            // System.out.println(sumCA);
            System.out.println(" C's as (trustee) trustworthiness towards A is (trusted) =  " + (float) ACH / TAC * 100 + "%");

            //System.out.println(sumCB);
            System.out.println(" C's as (trustee) trustworthiness towards B is (trusted) =   " + (float) BCH / TBC * 100 + "%");


        }
        System.out.println("*************************************************************************************************************************************************************************");

        System.out.println("============================================================================================================================================================================");
        System.out.println("==============================================================================================================================================================================");

        System.out.println("============================================================================================================================================================================");

        System.out.println(" INDIVIDUAL RECOMMENDATIONS CALCULATION FOR ALL THE NODES ");
        System.out.println("=================================================================================================================================================================================");

        //System.out.println(sumAB);
        System.out.println(" A's as (trustee) trustworthiness towards B is (trusted) =  " + (float) BAH / TBA * 100 + "%");

        // System.out.println(sumAC);
        System.out.println(" A's as (trustee)trustworthiness towards C is  (trusted) =  " + (float) CAH / TCA * 100 + "%");

        System.out.println("=====================================================================================================================================================================================");
        System.out.println(" B 's as (trustee) trustworthiness towards A  is  (trusted) =  " + (float) ABH / TAB * 100 + "%");

        //System.out.println(sumBC);
        System.out.println(" B 's as (trustee) trustworthiness towards C is  (trusted) =  " + (float) CBH / TCB * 100 + "%");

        System.out.println("=============================================================================================================================================================================================");
        System.out.println(" C's as  (trustee) trustworthiness towards A is (trusted) =  " + (float) ACH / TAC * 100 + "%");

        //System.out.println(sumCB);
        System.out.println(" C's as (trustee) trustworthiness towards B is  (trusted) =  " + (float) BCH / TBC * 100 + "%");




        System.out.println("Do you want to check shared attributes between A and B both devices");
        Scanner scanner10 = new Scanner(System.in);
        boolean ans = scanner10.nextBoolean();
        if (ans == true ) {


            if(  d1.getFirmVendor() != null  && (d2.getFirmVendor() != null )){
                if (d1.getFirmVendor().equals(d2.getFirmVendor())) {
                    System.out.println(" A and B both has same OS built-In");
                }}

            if ( d2.getFirmNum() != 0 && d1.getFirmNum() != 0){
                if (d2.getFirmNum() == d1.getFirmNum()) {
                    System.out.println(" A and B both has same OS Version");
                }}

            if( d1.getName() != null && d2.getName() != null){
                if (d1.getName().equals((d2.getName()))) {
                    System.out.println(" A and B both device has same Name");

                }}
            if (dc1.getIssuer() != null && dc2.getIssuer() != null)
                if (dc1.getIssuer().equals((dc2.getIssuer()))) {

                    System.out.println("A and B both device are certified by same CA authority");
                }
            if( d1.getFirmVendor() == null  && (d2.getFirmVendor() == null && d2.getFirmNum() == 0 && d1.getFirmNum() == 0  && d1.getName() == null && d2.getName() == null  && dc1.getIssuer() == null && dc2.getIssuer() == null  ))
            {System.out.println(" Not enough attributes to compare");}
        }

        System.out.println("Do you want to check shared attributes between B and C both devices");
        Scanner scanner11 = new Scanner(System.in);
        boolean ans1 = scanner11.nextBoolean();
        if (ans1 == true ) {


            if(  d3.getFirmVendor() != null  && (d2.getFirmVendor() != null )){
                if (d3.getFirmVendor().equals(d2.getFirmVendor())) {
                    System.out.println(" C and B both has same OS built-In");
                }}

            if ( d2.getFirmNum() != 0 && d3.getFirmNum() != 0){
                if (d2.getFirmNum() == d3.getFirmNum()) {
                    System.out.println(" C and B both has same OS Version");
                }}

            if( d3.getName() != null && d2.getName() != null){
                if (d3.getName().equals((d2.getName()))) {
                    System.out.println(" C and B both device has same Name");

                }}
            if (dc1.getIssuer() != null && dc2.getIssuer() != null)
                if (dc1.getIssuer().equals((dc2.getIssuer()))) {

                    System.out.println("C and B both device are certified by same CA authority");
                }
            if( d3.getFirmVendor() == null  && (d2.getFirmVendor() == null && d2.getFirmNum() == 0 && d3.getFirmNum() == 0  && d3.getName() == null && d2.getName() == null  && dc1.getIssuer() == null && dc2.getIssuer() == null  ))
            {System.out.println(" Not enough attributes to compare");}
        }


        System.out.println("Do you want to check shared protocols between A and C both devices");
        Scanner scanner12 = new Scanner(System.in);
        boolean ans2 = scanner12.nextBoolean();
        if (ans2 == true ) {


            if(  d3.getFirmVendor() != null  && (d1.getFirmVendor() != null )){
                if (d3.getFirmVendor().equals(d1.getFirmVendor())) {
                    System.out.println(" C and A both has same OS built-In");
                }}

            if ( d1.getFirmNum() != 0 && d3.getFirmNum() != 0){
                if (d1.getFirmNum() == d3.getFirmNum()) {
                    System.out.println(" C and A both has same OS Version");
                }}

            if( d3.getName() != null && d1.getName() != null){
                if (d3.getName().equals((d1.getName()))) {
                    System.out.println(" C and A both device has same Name");

                }}
            if (dc1.getIssuer() != null && dc2.getIssuer() != null)
                if (dc1.getIssuer().equals((dc2.getIssuer()))) {

                    System.out.println("C and A both device are certified by same CA authority");
                }
            if( d3.getFirmVendor() == null  && (d1.getFirmVendor() == null && d1.getFirmNum() == 0 && d3.getFirmNum() == 0  && d3.getName() == null && d1.getName() == null  && dc1.getIssuer() == null && dc2.getIssuer() == null  ))
            {System.out.println(" Not enough attributes to compare");}
        }


    }


}




















































////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                  /* System.out.println(" device A wants recommendation about B from C");
                    Scanner scanner123 = new Scanner(System.in);
                    boolean di123 = scanner123.nextBoolean();
                    if (di123) {
                        if (ds1.isInteracted() != null && ds1.isIsconfigured13() && ds2.isIsconfigured23() && ds3.isIsconfigured31() && ds3.isIsconfigured32() ) { /////// here we have to add ds3.isIsconfigured32() to make full trusted comm


                            System.out.println(" device C recommend device B WITH " + T2 + " TRUST LEVEL to device A as trusted entity");
                        } else {
                            System.out.println(" device C NOT recommend device A to device B as trusted entity");
                        }
                    }

                    ////

                    System.out.println(" device A wants recommendation about C from B");
                    Scanner scanner132 = new Scanner(System.in);
                    boolean di132 = scanner132.nextBoolean();
                    if (di132) {
                        if (ds1.isInteracted() != null && ds1.isIsconfigured12() && ds3.isIsconfigured32() && ds2.isIsconfigured21() && ds2.isIsconfigured23() && T3 >= T2) { /////// here we have to add ds3.isIsconfigured32() to make full trusted comm

                            System.out.println(" device B  recommend device C to device A as trusted entity");
                        } else {
                            System.out.println(" device B NOT recommend device C to device A as trusted entity");
                        }
                    } ///


                    System.out.println(" device B wants recommendation about A from C ");
                    Scanner scanner213 = new Scanner(System.in);
                    boolean di213 = scanner213.nextBoolean();
                    if (di213) {
                        if (ds1.isInteracted() != null && ds2.isIsconfigured23() && ds1.isIsconfigured13() && ds3.isIsconfigured32() && ds3.isIsconfigured31() && T1 >= T3) { /////// here we have to add ds3.isIsconfigured32() to make full trusted comm

                            System.out.println(" device 3 recommend device 1 to device 2 as trusted entity");
                        } else {
                            System.out.println(" device 3 NOT recommend device 1 to device 2 as trusted entity");
                        }
                    }


                    System.out.println(" device 2 wants recommendation about 3 from 1");
                    Scanner scanner231 = new Scanner(System.in);
                    boolean di231 = scanner231.nextBoolean();
                    if (di231) {
                        if (ds1.isInteracted() != null && ds2.isIsconfigured21() && ds3.isIsconfigured31() && ds1.isIsconfigured13() && ds1.isIsconfigured12() && T3 >= T1) { /////// here we have to add ds3.isIsconfigured32() to make full trusted comm

                            System.out.println(" device 1 recommend device 3 to device 2 as trusted entity");
                        } else {
                            System.out.println(" device 1 NOT recommend device 3 to device 2 as trusted entity");
                        }
                    }


                    System.out.println(" device 3 wants recommendation about 2 from 1");
                    Scanner scanner321 = new Scanner(System.in);
                    boolean di321 = scanner321.nextBoolean();
                    if (di321) {
                        if (ds1.isInteracted() != null && ds2.isIsconfigured21() && ds1.isIsconfigured12() && ds1.isIsconfigured13() && ds3.isIsconfigured31() && T2 >= T1) { /////// here we have to add ds3.isIsconfigured32() to make full trusted comm

                            System.out.println(" device 1 recommend device 2 to device 3 as trusted entity");
                        } else {
                            System.out.println(" device 1 NOT recommend device 2 to device 3 as trusted entity");
                        }
                    }

                    System.out.println(" device 3 wants recommendation about 1 from 2");
                    Scanner scanner312 = new Scanner(System.in);
                    boolean di312 = scanner312.nextBoolean();
                    if (di312) {
                        if (ds1.isInteracted() != null && ds2.isIsconfigured23() && ds1.isIsconfigured12() && ds3.isIsconfigured32() && ds2.isIsconfigured21() && T1 >= T2) { /////// here we have to add ds3.isIsconfigured32() to make full trusted comm

                            System.out.println(" device 2 recommend device 1 to device 3 as trusted entity");
                        } else {
                            System.out.println(" device 2 NOT recommend device 1 to device 3 as trusted entity");
                        }
                    }


                    System.out.println("Want to know is it reliable for Device 1 communicate with device 2  ?");
                    boolean a = scanner1.nextBoolean();
                    if (a == true) {
                        if (T1 == T2) {
                            System.out.println(" both devices at the same level of trust " + T1);
                        } else if (T1 > T2) {
                            System.out.println(" Device 1 has higher level of trust ");
                        } else if (T1 < T2) {
                            System.out.println(" Device 2 has higher level of trust ");
                    */

























///////////////FOR second device  info ////


//        DeviceAttribute d2 = new DeviceAttribute();
//
//        System.out.println("Enter second Device Name:");
//        String device_name2 = scanner.nextLine();
//        d2.setName(device_name2);
//
//        System.out.println("Enter 2 Device Description");
//        String desc2 = scanner.nextLine();
//        d2.setDesc(desc2);
//
//
//        System.out.println("Enter 2 Device ID:");
//        int id2 = scanner.nextInt();
//        d2.setDeviceID(id2);
//
//
//        System.out.println("Enter Physical address 2 (Mac address)");
//        String macadd2 = scanner.next();
//        d2.setMacadd(macadd2);
//
//        System.out.println("Enter 2 Firmware Vendor");
//        String firmwareVendor2 = scanner.next();
//        d2.setFirmVendor(firmwareVendor2);
//
//        System.out.println("Enter 2 Firmware Version");
//        double firmNum2 = scanner.nextDouble();
//        d2.setFirmNum(firmNum2);
//
//        System.out.println("Enter Hardware Vendor");
//        String hardwareVendor2 = scanner.next();
//        d2.setHardwareVendor(hardwareVendor2);
//
//
//        System.out.println("Enter Hardware Version");
//        float hardwareVersion2 = scanner.nextFloat();
//        d2.setHardwareVersion(hardwareVersion2);
//
//        System.out.println("Enter Serial Number");
//        int serialNumber2 = scanner.nextInt();
//        d2.setSerialNumber(serialNumber2);
//
//
//        ////////////Device status
//        //System.out.println("Device Status");
//
//        DeviceStatus ds2 = new DeviceStatus();
//
//        System.out.println("Device On");
//        boolean isOn2 = scanner.nextBoolean();
//        ds2.setOn(isOn2);
//
//        System.out.println("Device Configured");
//        boolean isConfigured2 = scanner.nextBoolean();
//        ds2.setIsconfigured(isConfigured2);
//
//
//        ///////////Device certificate
//
//        System.out.println("Details about Digital certificate");
//
//        DeviceCertificate dc2 = new DeviceCertificate();
//
//        System.out.println("Enter issuer authority name");
//        String issuer2 = scanner.next();
//        dc2.setIssuer(issuer2);
//
//
//        System.out.println("Enter serial number");
//        int sernum2 = scanner.nextInt();
//        dc2.setSerialNumber(sernum2);
//
//        System.out.println("Enter the signature algorithm it uses");
//        String signalgo2 = scanner.next();
//        dc2.setSignAlgo(signalgo2);
//
//        System.out.println("Enter the date of issue");
//        String date2 = scanner.next();
//        dc2.setDateOfIssue(date2);
//
//        System.out.println("Enter the expiration date");
//        String validity2 = scanner.next();
//        dc2.setValidity(validity2);


///////////Trust relationship checking///////////
//System.out.println("Trust relationship checking");
//
//        if () {
//
//
//            if (!(id == 0) && (macadd == null) && !(firmNum == 0) && !(sernum == sernum2) && !(signalgo == signalgo2) && !(date == date2) && !(validity == validity2)) {
//                System.out.println(" Level 5 Trust");
//            }
//
//
////        }




