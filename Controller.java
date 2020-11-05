package com.company;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Controller {
    Connection conn;

    Controller (Connection conn){
        this.conn = conn;
    }

    void addingCityObject(String objectType, String objectAdress, String objectName, String objectOwner, String objectPhone, Date objectOpenDate, Date objectCloseDate){
        PreparedStatement addingCityObjectStatement = null;
        try{
            addingCityObjectStatement = conn.prepareStatement("INSERT INTO city_objects(object_type, adress, object_name, owner_FIO, contact_phone, open_date, close_date) VALUES (?, ?, ?, ?, ?, ?, ?)");
            addingCityObjectStatement.setString(1, objectType);
            addingCityObjectStatement.setString(2, objectAdress);
            addingCityObjectStatement.setString(3, objectName);
            addingCityObjectStatement.setString(4, objectOwner);
            addingCityObjectStatement.setString(5, objectPhone);
            addingCityObjectStatement.setDate(6, objectOpenDate);
            addingCityObjectStatement.setDate(7, objectCloseDate);
            addingCityObjectStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void updatingCityObject(String objectType, String objectAdress, String objectName, String objectOwner, String newObjectType, String newObjectAdress, String newObjectName, String newObjectOwner, String newObjectPhone, Date newObjectOpenDate,  Date objectCloseDate){
        PreparedStatement updatingCityObjectStatement = null;
        try{
            updatingCityObjectStatement = conn.prepareStatement("UPDATE city_objects SET object_type = ?, adress = ?, object_name = ?, owner_FIO= ?, contact_phone = ?, open_date= ?, close_date = ? WHERE object_type = ? && adresss = ? && object_name = ? && owner_FIO = ?");
            updatingCityObjectStatement.setString(1, newObjectType);
            updatingCityObjectStatement.setString(2, newObjectAdress);
            updatingCityObjectStatement.setString(3, newObjectName);
            updatingCityObjectStatement.setString(4, newObjectOwner);
            updatingCityObjectStatement.setString(5, newObjectPhone);
            updatingCityObjectStatement.setDate(6, newObjectOpenDate);
            updatingCityObjectStatement.setDate(7, objectCloseDate);
            updatingCityObjectStatement.setString(8, objectType);
            updatingCityObjectStatement.setString(9, objectAdress);
            updatingCityObjectStatement.setString(10, objectName);
            updatingCityObjectStatement.setString(11, objectOwner);
            updatingCityObjectStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deletingCityObject(String objectType, String objectAdress, String objectName, String objectOwner){
        PreparedStatement deletingCityObjectStatement = null;
        try{
            deletingCityObjectStatement = conn.prepareStatement("DELETE FROM  city_objects WHERE object_type = ? && adress = ? && object_name = ? && owner_FIO = ?");
            deletingCityObjectStatement.setString(1, objectType);
            deletingCityObjectStatement.setString(2, objectAdress);
            deletingCityObjectStatement.setString(3, objectName);
            deletingCityObjectStatement.setString(4, objectOwner);
            deletingCityObjectStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void addingOwners(Integer ownerType, String ownerInfo, String objectName){
        PreparedStatement addingOwnersStatement = null;
        try{
            addingOwnersStatement = conn.prepareStatement("INSERT INTO owners(owner_info, owner_FIO, object_name) VALUES (?, ?, ?)");
            addingOwnersStatement.setInt(1, ownerType);
            addingOwnersStatement.setString(2, ownerInfo);
            addingOwnersStatement.setString(3, objectName);
            addingOwnersStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    void updatingOwners(Integer ownerType, String ownerInfo, String objectName, Integer newOwnerType, String newOwnerInfo, String newObjectName){
        PreparedStatement updatingOwnersStatement = null;
        try{
            updatingOwnersStatement = conn.prepareStatement("UPDATE owners SET owner_info = ?, owner_FIO = ?, object_name = ? WHERE owner_info = ? && owner_FIO = ? && object_name = ?");
            updatingOwnersStatement.setInt(1, newOwnerType);
            updatingOwnersStatement.setString(2, newOwnerInfo);
            updatingOwnersStatement.setString(3, newObjectName);
            updatingOwnersStatement.setInt(4, ownerType);
            updatingOwnersStatement.setString(5, ownerInfo);
            updatingOwnersStatement.setString(6, objectName);
            updatingOwnersStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deletingOwners(Integer ownerType, String ownerInfo, String objectName){
        PreparedStatement deletingOwnersStatement = null;
        try{
            deletingOwnersStatement = conn.prepareStatement("DELETE FROM owners WHERE owner_info = ? && owner_FIO = ? && object_name = ?");
            deletingOwnersStatement.setInt(1, ownerType);
            deletingOwnersStatement.setString(2, ownerInfo);
            deletingOwnersStatement.setString(3, objectName);
            deletingOwnersStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void addingPopularty(Date populartyDate, Integer visits, String objectName){
        PreparedStatement addingPopulartyStatement = null;
        try{
            addingPopulartyStatement = conn.prepareStatement("INSERT INTO popularty(visit_date, visits, object_name) VALUES (?, ?, ?)");
            addingPopulartyStatement.setDate(1, populartyDate);
            addingPopulartyStatement.setInt(2, visits);
            addingPopulartyStatement.setString(3, objectName);
            addingPopulartyStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void updatingPopularty(Date populartyDate, Integer visits, String objectName, Date newPopulartyDate, Integer newVisits, String newObjectName){
        PreparedStatement updatingPopulartyStatement = null;
        try{
            updatingPopulartyStatement = conn.prepareStatement("UPDATE popularty SET visit_date = ?, visits = ?, object_name = ? WHERE visit_date = ?, visits = ?, object_name= ?");
            updatingPopulartyStatement.setDate(1, newPopulartyDate);
            updatingPopulartyStatement.setInt(2, newVisits);
            updatingPopulartyStatement.setString(3, newObjectName);
            updatingPopulartyStatement.setDate(4, populartyDate);
            updatingPopulartyStatement.setInt(5, visits);
            updatingPopulartyStatement.setString(6, objectName);
            updatingPopulartyStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deletingPopularty(Date populartyDate, Integer visits, String objectName){
        PreparedStatement deletingPopulartyStatement = null;
        try{
            deletingPopulartyStatement = conn.prepareStatement("DELETE FROM popularty WHERE visit_date = ?, visits = ?, object_name= ?");
            deletingPopulartyStatement.setDate(1, populartyDate);
            deletingPopulartyStatement.setInt(2, visits);
            deletingPopulartyStatement.setString(3, objectName);
            deletingPopulartyStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void addingIvents(String objectName, Date inventDate, String inventName, String inventType){
        PreparedStatement addingIventsStatement = null;
        try{
            addingIventsStatement = conn.prepareStatement("INSERT INTO ivents(object_name, ivent_date, ivent_name, ivent_type) VALUES (?, ?, ?, ?)");
            addingIventsStatement.setString(1, objectName);
            addingIventsStatement.setDate(2, inventDate);
            addingIventsStatement.setString(3, inventName);
            addingIventsStatement.setString(4, inventType);
            addingIventsStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void updatingIvents(String objectName, Date inventDate, String inventName, String inventType, String newObjectName, Date newInventDate, String newInventName, String newInventType){
        PreparedStatement updatingIventsStatement = null;
        try{
            updatingIventsStatement = conn.prepareStatement("UPDATE ivents SET object_name=?, ivent_date=?, ivent_name=?, ivent_type=? WHERE object_name=?, ivent_date=?, ivent_name=?, ivent_type=?");
            updatingIventsStatement.setString(1, newObjectName);
            updatingIventsStatement.setDate(2, newInventDate);
            updatingIventsStatement.setString(3, newInventName);
            updatingIventsStatement.setString(4, newInventType);
            updatingIventsStatement.setString(5, objectName);
            updatingIventsStatement.setDate(6, inventDate);
            updatingIventsStatement.setString(7, inventName);
            updatingIventsStatement.setString(8, inventType);
            updatingIventsStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deletingIvents(String objectName, Date inventDate, String inventName, String inventType){
        PreparedStatement deletingIventsStatement = null;
        try{
            deletingIventsStatement = conn.prepareStatement("DELETE FROM ivents WHERE object_name=?, ivent_date=?, ivent_name=?, ivent_type=?");
            deletingIventsStatement.setString(1, objectName);
            deletingIventsStatement.setDate(2, inventDate);
            deletingIventsStatement.setString(3, inventName);
            deletingIventsStatement.setString(4, inventType);
            deletingIventsStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void findingObjectsOnCurrutDate(Date currentDate){
        PreparedStatement findingObjectsOnCurrutDateStatement = null;
        try{
            findingObjectsOnCurrutDateStatement = conn.prepareStatement("SELECT object_type, object_name, adress FROM city_objects WHERE ? > open_date AND close_date >= ?");
            findingObjectsOnCurrutDateStatement.setDate(1, currentDate);
            findingObjectsOnCurrutDateStatement.setDate(2, currentDate);
            ResultSet result = findingObjectsOnCurrutDateStatement.executeQuery();
            while(result.next()){
                String objectType = result.getString("object_type");
                String objectName = result.getString("object_name");
                String objectAdress = result.getString("adress");
                System.out.println(objectType + " " + objectName + " " + objectAdress);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void findingIventsTwoWeekAhead(Date currentDate){
        PreparedStatement findingIventsTwoWeekAheadStatement = null;
        LocalDateTime TwoDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().plusDays(14);
        java.util.Date data = java.util.Date.from(TwoDate.atZone(ZoneId.systemDefault()).toInstant());
        Date endDate = new Date(data.getTime());
        try{
            findingIventsTwoWeekAheadStatement = conn.prepareStatement("SELECT * FROM ivents WHERE ivent_date >= ? AND ? > ivent_date");
            findingIventsTwoWeekAheadStatement.setDate(1, currentDate);
            findingIventsTwoWeekAheadStatement.setDate(2, endDate);
            ResultSet result = findingIventsTwoWeekAheadStatement.executeQuery();
            while(result.next()){
                String objectName = result.getString("object_name");
                String iventDate = result.getDate("ivent_date").toString();
                String iventAdress = result.getString("ivent_name");
                String iventType = result.getString("ivent_type");
                System.out.println(objectName + " " + iventDate + " " + iventAdress + " " + iventType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void findObjectsOnType(String objectType, Date currentDate){
        PreparedStatement findObjectsOnTypeStatement = null;
        try{
            findObjectsOnTypeStatement = conn.prepareStatement("SELECT object_name, adress FROM city_objects WHERE ? > open_date AND close_date > ? && object_type LIKE ?");
            findObjectsOnTypeStatement.setDate(1, currentDate);
            findObjectsOnTypeStatement.setDate(2, currentDate);
            findObjectsOnTypeStatement.setString(3, objectType);
            ResultSet result = findObjectsOnTypeStatement.executeQuery();
            while(result.next()){
                String objectName = result.getString("object_name");
                String iventAdress = result.getString("adress");
                System.out.println(objectName + " " + iventAdress);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
