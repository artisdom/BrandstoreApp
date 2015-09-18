package com.brandstore1.utils;

import android.net.Uri;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by I076324 on 7/22/2015.
 */
public class Connections {
    // SET THIS BOOLEAN VARIABLE TO FALSE FOR TESTING
    public static boolean isLiveSystem=true;

    public static String ipAddress  = "ec2-52-26-206-185.us-west-2.compute.amazonaws.com";
    private String systemName="brandstore";
    String versionName="v2";
    String userId ="6";
    public Connections(){
        if(!isLiveSystem){
            setSystemName("beta");
        }
        //fetch userId from SharedPreferences
    }

    public String getUpdateRegIdURL(String userId,String registrationId){
        String request="";
        try {
            URI uri= new URI(
                    "http",
                    ipAddress,
                    getStartParametersOfURL() +"updateRegID",
                    "userid="+userId+"&regid="+registrationId,
                    null);
            request = uri.toASCIIString();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return request;
    }

    public String getLoginURL(String emailId , String password){
        String request="";
        try {
            URI uri= new URI(
                    "http",
                    ipAddress,
                    getStartParametersOfURLForSailsModel() +"user",
                    "emailid="+emailId+"&password="+password,
                    null);
            request = uri.toASCIIString();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return request;
    }

    public String getForgotPasswordURL(String emailId ){
        String request="";
        try {
            URI uri= new URI(
                    "http",
                    ipAddress,
                    getStartParametersOfURL() +"forgotPassword",
                    "emailid="+emailId,
                    null);
            request = uri.toASCIIString();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return request;
    }

    public String getSignUpURL(String firstName , String lastName , String emailId , String password ,String genderCode){
        String request="";
        try {
            URI uri= new URI(
                    "http",
                    ipAddress,
                    getStartParametersOfURL() +"signup",
                    "firstname="+firstName+"&lastname="+lastName+"&emailid="+emailId+"&password="+password +"&gendercode="+genderCode,
                    null);
            request = uri.toASCIIString();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return request;
    }

    public String getSuggestionsURL(String userId, String query ){
        String request="";
        try {
            URI uri= new URI(
                    "http",
                    ipAddress,
                    getStartParametersOfURL() +"getSuggestions",
                    "q="+query+"&userid="+userId,
                    null);
            request = uri.toASCIIString();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return request;
    }

    public String getOutletListURL(String userId, String tagId ){
        String request="";
        try {
            URI uri= new URI(
                    "http",
                    ipAddress,
                    getStartParametersOfURL() +"getOutlets",
                    "userid="+userId+"&id="+tagId,
                    null);
            request = uri.toASCIIString();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return request;
    }

    public String getAllFavoriteOutletsURL(String userId ){
        String request="";
        try {
            URI uri= new URI(
                    "http",
                    ipAddress,
                    getStartParametersOfURL() +"getAllFavoriteOutlets",
                    "userid="+userId,
                    null);
            request = uri.toASCIIString();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return request;
    }

    public String getAllOnSaleOutletsURL(String userId ){
        String request="";
        try {
            URI uri= new URI(
                    "http",
                    ipAddress,
                    getStartParametersOfURL() +"getAllOnSaleOutlets",
                    "userid="+userId,
                    null);
            request = uri.toASCIIString();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return request;
    }


    public String getOutletDetailsURL(String userId, String outletId ){
        String request="";
        try {
            URI uri= new URI(
                    "http",
                    ipAddress,
                    getStartParametersOfURL() +"getOutletDetails",
                    "userid="+userId+"&id="+outletId,
                    null);
            request = uri.toASCIIString();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return request;
    }


    public String getSetFavoriteOutletURL(String userId , String outletId , boolean toBeSet){
        String request="";
        try {
            URI uri= new URI(
                    "http",
                    ipAddress,
                    getStartParametersOfURL() +"setFavoriteOutlet",
                    "userid="+userId+"&outletid="+outletId+"&set="+toBeSet,
                    null);
            request = uri.toASCIIString();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return request;
    }

    public String getTakeMeThereURL(String userId , String fromOutletId , String toOutletId  ){
        String request="";
        try {
            URI uri= new URI(
                    "http",
                    ipAddress,
                    getStartParametersOfURL() +"getTakeMeThereCommands",
                    "userid="+userId+"&fromoutletid="+fromOutletId+"tooutletid="+toOutletId,
                    null);
            request = uri.toASCIIString();
        }catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return request;
    }









    public String getStartParametersOfURL(){
        if(isLiveSystem){
            return "/"+versionName+"/";
        }
        return "/"+ getSystemName() +"/"+versionName+"/";
    }
    public String getStartParametersOfURLForSailsModel(){
        if(isLiveSystem){
            return "/";
        }
        return "/"+ getSystemName() +"/";
    }


    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }


    public String getSystemNameCamelCase() {
        if(systemName.equals("beta")) return "Beta";
        else return "Brandstore";
    }


}
