/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Film extends DBContext {

    private int id;
    private String name1, name2, status, directorName, actor;
    private int category_Id, type_Movie, nation_id, year;
    private String image, description;
    private int duration;
    private int num_view;
    private String author, updateFilm;
    Connection cnn = connection;
    ResultSet rs;
    PreparedStatement stm;
    private static ArrayList<Film> listUpdateFilm = new ArrayList<>();

    public Film() {
        connect();
    }

    public Film(int id, String name1, String name2, String status, String directorName, String actor, int category_Id, int type_Movie, int nation_id, int year, String image, String description, int duration, int num_view, String author, String updateFilm) {
        connect();
        this.id = id;
        this.name1 = name1;
        this.name2 = name2;
        this.status = status;
        this.directorName = directorName;
        this.actor = actor;
        this.category_Id = category_Id;
        this.type_Movie = type_Movie;
        this.nation_id = nation_id;
        this.year = year;
        this.image = image;
        this.description = description;
        this.duration = duration;
        this.num_view = num_view;
        this.author = author;
        this.updateFilm = updateFilm;
    }

   public static ArrayList<Film> getListUpdateFilm() {
        return listUpdateFilm;
    }

    public static void addFilmToUpdateList(Film film) {
        listUpdateFilm.add(film);
    }

    public String getUpdateFilm() {
        return updateFilm;
    }

    public void setUpdateFilm(String updateFilm) {
        this.updateFilm = updateFilm;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(int category_Id) {
        this.category_Id = category_Id;
    }

    public int getType_Movie() {
        return type_Movie;
    }

    public void setType_Movie(int type_Movie) {
        this.type_Movie = type_Movie;
    }

    public int getNation_id() {
        return nation_id;
    }

    public void setNation_id(int nation_id) {
        this.nation_id = nation_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getNum_view() {
        return num_view;
    }

    public void setNum_view(int num_view) {
        this.num_view = num_view;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void connect() {
        if (cnn != null) {
            System.out.println("Connect succ!");
        } else {
            System.out.println("Failed!");
        }
    }

    public ArrayList<Film> getListFilm(String key, int choice) {
        ArrayList<Film> data = new ArrayList<Film>();
        try {
            String sliSQL = "";
            if (choice == 1) {
                sliSQL = "select * from Movie where category_id=?";
                stm = connection.prepareStatement(sliSQL);
                stm.setString(1, key);
            } else if (choice == 0) {
                sliSQL = "select * from Movie where type_movie=?";
                stm = connection.prepareStatement(sliSQL);
                stm.setString(1, key);
            } else if (choice == -1) {
                sliSQL = "select * from Movie where FilmID =? or FilmName1 like ? or FilmName2 like ? or director like ? or actor like ?";
                stm = connection.prepareStatement(sliSQL);
                stm.setString(1, checkSearch(key));
                stm.setString(2, "%" + key + "%");
                stm.setString(3, "%" + key + "%");
                stm.setString(4, "%" + key + "%");
                stm.setString(5, "%" + key + "%");
            } else if (choice == 2) {
                sliSQL = "select * from Movie m where m.nation_id =?";
                stm = connection.prepareStatement(sliSQL);
                stm.setString(1, key);
            } else if (choice == -2) {
                sliSQL = "select * from Movie m where m.actor like ?";
                stm = connection.prepareStatement(sliSQL);
                stm.setString(1, "%" + key + "%");
            } else {
                sliSQL = "select * from movie m where m.FilmID =?";
                stm = connection.prepareStatement(sliSQL);
                stm.setString(1, key);
            }
            rs = stm.executeQuery();
            while (rs.next()) {//Vòng lặp while sau đó lặp qua từng hàng của tập kết quả bằng cách sử dụng phương thức next() và nếu nó tìm thấy ít nhất một hàng phù hợp, phương thức này sẽ trả về giá trị true cho biết rằng việc đăng nhập đã thành công.
                //C1 String name=rs.getString("name");
                int Filmid = Integer.parseInt(rs.getString(1));
                String FilmName1 = rs.getString(2);
                String FilmName2 = rs.getString(3);
                String status = rs.getString(4);
                String director = rs.getString(5);
                String actor = rs.getString(6);
                int CateId = Integer.parseInt(rs.getString(7));
                int typeFilm = Integer.parseInt(rs.getString(8));
                int nationId = Integer.parseInt(rs.getString(9));
                int year = Integer.parseInt(rs.getString(10));
                String image = rs.getString(11);
                String descrip = rs.getString(12);
                int duration = Integer.parseInt(rs.getString(13));
                int num_view = Integer.parseInt(rs.getString(14));
                String author = rs.getString(15);
                String updateFilm = rs.getString(16);
                Film f = new Film(Filmid, FilmName1, FilmName2, convertString(status), convertString(director), convertString(actor), CateId, typeFilm, nationId, year, image, descrip, duration, num_view, convertString(author), updateFilm);
                data.add(f);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return data;
    }

    public ArrayList<Rating> getListRating(String key) {
        ArrayList<Rating> data = new ArrayList<>();
        try {
            String sql = "select * from Rating r where r.idFilm = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, key);
            rs = stm.executeQuery();
            while (rs.next()) {
                String markReport = rs.getString(3);
                String numReport = rs.getString(4);
                Rating rating = new Rating(markReport, numReport);
                data.add(rating);
            }
        } catch (Exception e) {
            System.out.println("ErrorGetListRating: " + e.getMessage());
        }
        return data;
    }

    public String convertCate(int key) {
        switch (key) {
            case 1:
                return "Narration";
            case 2:
                return "Funny";
            case 3:
                return "Cartoon";
            case 4:
                return "Action";
            case 5:
                return "Adventure";
            case 6:
                return "Fiction";
            case 7:
                return "KungFu";
            case 8:
                return "Tv Show";
            case 9:
                return "Drama";
            case 10:
                return "old film";
        }
        return "";
    }

    public String convertType(int type) {
        switch (type) {
            case 2:
                return "Phim Bộ";
            case 1:
                return "Phim Lẻ";
            case 3:
                return "Phim Chiếu Rạp";
        }
        return "";
    }

    public String convertNation(int nationId) {
        switch (nationId) {
            case 1:
                return "America";
            case 2:
                return "VietNam";
            case 3:
                return "France";
            case 4:
                return "Japan";
            case 5:
                return "Korean";
            case 6:
                return "United Kingdom";
            case 7:
                return "China";
            case 8:
                return "Canada";
            case 9:
                return "Hồng Kông";
            case 10:
                return "Thai Land";
        }
        return "";
    }

    public String convertString(String key) {
        if (key.equals("Không xác d?nh")) {
            return "Unknown!";
        } else if (key.startsWith("T?p")) {
            String[] split = key.split("[^\\d/]"); // Tách chuỗi theo các ký tự không phải là số hoặc "/"
            for (String string : split) {
                if (!string.isEmpty()) {
                    return string;
                }
            }
        } else if (key.replaceAll("\\s+$", "").contains("Hoàn t?t")) {
            if (key.matches(".*\\(\\d+/\\d+\\).*")) {// .*: Đại diện cho bất kỳ ký tự nào (kể cả không có hoặc nhiều ký tự). Dấu chấm . biểu thị cho bất kỳ ký tự nào và * biểu thị cho việc lặp lại từ 0 đến nhiều lần.
                //\\(\\d+/\\d+\\): Đại diện cho một chuỗi có dạng "(số/số)". Dấu \\( biểu thị cho ký tự mở ngoặc đơn (. \\d+ biểu thị cho một hoặc nhiều ký tự số. \\+ biểu thị cho ký tự "+". Sau đó, \\d+ lại biểu thị cho một hoặc nhiều ký tự số tiếp theo. Cuối cùng, \\) biểu thị cho ký tự đóng ngoặc đơn ).
                String[] split = key.split("[^(\\d/)]"); // Tách chuỗi theo các ký tự không phải là số hoặc "/"
                for (String string : split) {
                    if (!string.isEmpty()) {
                        return string;
                    }
                }
            }
            return "Complete";
        } else {
            return key;
        }
        return key;
    }

    public String checkSearch(String check) {
        try {
            Integer.parseInt(check);
            return check;
        } catch (Exception e) {
            return null;
        }
    }

    public String convertSrcImg(String src) {
        return "images/" + src;
    }

    public ArrayList<Actor> getListActor() {
        ArrayList<Actor> data = new ArrayList<>();
        try {
            String sliSQL = "select * from Actor";
            stm = connection.prepareStatement(sliSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                int Id = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                int idNational = Integer.parseInt(rs.getString(3));
                int birthYear = Integer.parseInt(rs.getString(4));
                String description = rs.getString(5);
                String image = rs.getString(6);
                String filmID = rs.getString(7);
                data.add(new Actor(Id, name, idNational, birthYear, description, image, filmID));
            }
        } catch (Exception e) {
            System.out.println("Error GetlistActor: " + e.getMessage());
        }
        return data;
    }
    public ArrayList<Actor> getListActorByIDAct(String id) {
        ArrayList<Actor> data = new ArrayList<>();
        try {
            String sliSQL = "select * from Actor where ID = ?";
            stm = connection.prepareStatement(sliSQL);
            stm.setString(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                int Id = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                int idNational = Integer.parseInt(rs.getString(3));
                int birthYear = Integer.parseInt(rs.getString(4));
                String description = rs.getString(5);
                String image = rs.getString(6);
                String filmID = rs.getString(7);
                data.add(new Actor(Id, name, idNational, birthYear, description, image, filmID));
            }
        } catch (Exception e) {
            System.out.println("Error getListActorByIDAct: " + e.getMessage());
        }
        return data;
    }

    public ArrayList<Actor> getListActorByIDfilm(String id) {
        ArrayList<Actor> data = new ArrayList<>();
        try {
            String sliSQL = "select * from Actor where filmID like ?";
            stm = connection.prepareStatement(sliSQL);
            stm.setString(1, "%" + id + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                int Id = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                int idNational = Integer.parseInt(rs.getString(3));
                int birthYear = Integer.parseInt(rs.getString(4));
                String description = rs.getString(5);
                String image = rs.getString(6);
                String filmID = rs.getString(7);
                data.add(new Actor(Id, name, idNational, birthYear, description, image, filmID));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return data;
    }

    public double calculateMark(double markReport, int numReport, int markChose) {
        double sumvalueBeforeDeivde = markReport * numReport;
        double result = (sumvalueBeforeDeivde + markChose) / (numReport + 1);
        String format = String.format("%.2f", result);
        return Double.parseDouble(format);
    }

    public void UpdateRatingById(String id, int mark) {
        ArrayList<Rating> data = getListRating(id);
        System.out.println(Double.parseDouble(data.get(0).getMarkReport()));
        System.out.println(Integer.parseInt(data.get(0).getNumReport()));
        try {
            String sql = "Update Rating set markReport =?, numReport = ? where idFilm = ?";
            stm = connection.prepareStatement(sql);
            stm.setDouble(1, calculateMark(Double.parseDouble(data.get(0).getMarkReport()), Integer.parseInt(data.get(0).getNumReport()), mark));
            stm.setInt(2, Integer.parseInt(data.get(0).getNumReport()) + 1);
            stm.setInt(3, Integer.parseInt(id));
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error when update Rating: " + e.getMessage());
        }
    }

    public ArrayList<Rating> getListRating() {
        ArrayList<Rating> data = new ArrayList<>();
        try {
            String sql = "select * from Rating";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String idFilm = rs.getString(1);
                String nameFilm = rs.getString(2);
                String markReport = rs.getString(3);
                String numReport = rs.getString(4);
                Rating rating = new Rating(idFilm, nameFilm, numReport, numReport);
                data.add(rating);
            }
        } catch (Exception e) {
            System.out.println("ErrorGetListRating: " + e.getMessage());
        }
        return data;
    }

    public ArrayList<National> getNationList() {
        ArrayList<National> data = new ArrayList<>();
        try {
            String sql = "select * from Nation";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                data.add(new National(Integer.parseInt(id), name));
            }
        } catch (Exception e) {
            System.out.println("ErrorGetListNation: " + e.getMessage());
        }
        return data;
    }

    public ArrayList<typeMovie> getTypeList() {
        ArrayList<typeMovie> data = new ArrayList<>();
        try {
            String sql = "select * from typeMovie";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(3);
                data.add(new typeMovie(Integer.parseInt(id), name));
            }
        } catch (Exception e) {
            System.out.println("ErrorGetListType: " + e.getMessage());
        }
        return data;
    }

    public ArrayList<Category> getCateList() {
        ArrayList<Category> data = new ArrayList<>();
        try {
            String sql = "select * from Category";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                data.add(new Category(Integer.parseInt(id), name));
            }
        } catch (Exception e) {
            System.out.println("ErrorGetListCate: " + e.getMessage());
        }
        return data;
    }

    public boolean updateFilmByID() {
        try {
            String sliSQL = "update movie set FilmName1 = ?, FilmName2 = ? ,Status = ?, director = ?, actor= ? , category_id=?,type_movie= ? ,nation_id = ?, year= ?,image=?,description = ?, duration= ?, num_view = ?,author=? , updateFilm =? where FilmID = ?";
            stm = connection.prepareStatement(sliSQL);
            stm.setString(1, name1);
            stm.setString(2, name2);
            stm.setString(3, status);
            stm.setString(4, directorName);
            stm.setString(5, actor);
            stm.setInt(6, category_Id);
            stm.setInt(7, type_Movie);
            stm.setInt(8, nation_id);
            stm.setInt(9, year);
            stm.setString(10, image);
            stm.setString(11, description);
            stm.setInt(12, duration);
            stm.setInt(13, num_view);
            stm.setString(14, author);
            stm.setString(15, "1");
            stm.setInt(16, id);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(" error Update Film: " + e.getMessage());
        }
        return false;
    }

    public boolean updateRating(double mark, int num, int id) {
        try {
            String sliSQL = "update Rating set markReport = ?, numReport = ? where idFilm = ?";
            stm = connection.prepareStatement(sliSQL);
            stm.setDouble(1, mark);
            stm.setInt(2, num);
            stm.setInt(3, id);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(" error Update Rating: " + e.getMessage());
        }
        return false;
    }
    public boolean updateActorByID(String id, String name ,String natId, String Birth, String des, String filmId) {
        try {
            String sliSQL = "update actor set Name = ?, NationalId = ?, BrthYear = ?, Description = ?,filmID =? where ID = ?";
            stm = connection.prepareStatement(sliSQL);
            stm.setString(1, name);
            stm.setString(2, natId);
            stm.setString(3, Birth);
            stm.setString(4, des);
            stm.setString(5, filmId);
            stm.setString(6, id);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(" error Update ActorByID: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteFIlmById(String id) {
        try {
            String sql = "DELETE FROM Movie WHERE FilmID = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting row FIlm: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteRatingById(String id) {
        try {
            String sql = "DELETE FROM Rating WHERE idFilm = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting row Rating: " + e.getMessage());
        }
        return false;
    }
    public boolean deleteActorById(String id) {
        try {
            String sql = "DELETE FROM Actor WHERE ID = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting row Actor: " + e.getMessage());
        }
        return false;
    }


    public boolean addFilm() {
        try {
            String strSQL = "insert into Movie (FilmName1, FilmName2, Status, director, actor, category_id, type_movie, nation_id, year, image, description, duration, num_view, author, updateFilm) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?)";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, name1);
            stm.setString(2, name2);
            stm.setString(3, status);
            stm.setString(4, directorName);
            stm.setString(5, actor);
            stm.setInt(6, category_Id);
            stm.setInt(7, type_Movie);
            stm.setInt(8, nation_id);
            stm.setInt(9, year);
            stm.setString(10, image);
            stm.setString(11, description);
            stm.setInt(12, duration);
            stm.setInt(13, num_view);
            stm.setString(14, author);
            stm.setString(15, "1");
            stm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addFilm" + e.getMessage());
        }
        return false;
    }

    public boolean addRating(int id, String name, double mark, int numrp) {
        try {
            String strSQL = "insert into Rating (idFilm,nameFilm,markReport,numReport) values (?,?,?,?)";
            stm = cnn.prepareStatement(strSQL);
            stm.setInt(1, id);
            stm.setString(2, name);
            stm.setDouble(3, mark);
            stm.setInt(4, numrp);
            stm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addRAting: " + e.getMessage());
        }
        return false;
    }

    public boolean addActor(String name, int idNational, int birthYear, String description, String image, String filmID) {
        try {
            String strSQL = "insert into Actor (Name,NationalId,BrthYear,Description,images, filmID) values (?,?,?,?,?,?)";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, name);
            stm.setInt(2, idNational);
            stm.setInt(3, birthYear);
            stm.setString(4, description);
            stm.setString(5, image);
            if (filmID.equals("0")) {
                stm.setString(6, "UnKnown!");
            } else {
                stm.setString(6, filmID);
            }
            stm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addActor: " + e.getMessage());
        }
        return false;
    }

    public boolean addCate(String name) {
        try {
            String sql = "insert into Category (CategoryName) values (?)";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, name);
            stm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("add Category error: " + e.getMessage());
            return false;
        }
    }

    public boolean addCountry(String name) {
        try {
            String sql = "insert into Nation (NationName) values (?)";
            stm = cnn.prepareStatement(sql);
            stm.setString(1, name);
            stm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("add Country error: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Film> getListFilm() {
        ArrayList<Film> data = new ArrayList<>();
        try {
            String sql = "select * from Movie";
            stm = cnn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int Filmid = Integer.parseInt(rs.getString(1));
                String FilmName1 = rs.getString(2);
                String FilmName2 = rs.getString(3);
                String status = rs.getString(4);
                String director = rs.getString(5);
                String actor = rs.getString(6);
                int CateId = Integer.parseInt(rs.getString(7));
                int typeFilm = Integer.parseInt(rs.getString(8));
                int nationId = Integer.parseInt(rs.getString(9));
                int year = Integer.parseInt(rs.getString(10));
                String image = rs.getString(11);
                String descrip = rs.getString(12);
                int duration = Integer.parseInt(rs.getString(13));
                int num_view = Integer.parseInt(rs.getString(14));
                String author = rs.getString(15);
                String updateFilm = rs.getString(16);
                Film f = new Film(Filmid, FilmName1, FilmName2, convertString(status), convertString(director), convertString(actor), CateId, typeFilm, nationId, year, image, descrip, duration, num_view, convertString(author), updateFilm);
                data.add(f);
            }
        } catch (Exception e) {
            System.out.println("getListFilm was error:" + e.getMessage());
        }
        return data;
    }
    public boolean checkActorExist(String name, String filmId) {
        try{
            String sql = "select * from Actor where Name = ? and filmID like ?";
            stm= cnn.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, "%" + filmId + "%");
            rs = stm.executeQuery();
            while(rs.next()) {
                return true;
            }
        }catch(Exception e) {
            System.out.println("Check Actor exists: " + e.getMessage());
        }return false;
    }
    
    public ArrayList<Film> getListFilmUpdate() {
        ArrayList<Film> data = new ArrayList<>();
        try {
            String sql = "select * from Movie m where m.updateFilm =1";
            stm = cnn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int Filmid = Integer.parseInt(rs.getString(1));
                String FilmName1 = rs.getString(2);
                String FilmName2 = rs.getString(3);
                String status = rs.getString(4);
                String director = rs.getString(5);
                String actor = rs.getString(6);
                int CateId = Integer.parseInt(rs.getString(7));
                int typeFilm = Integer.parseInt(rs.getString(8));
                int nationId = Integer.parseInt(rs.getString(9));
                int year = Integer.parseInt(rs.getString(10));
                String image = rs.getString(11);
                String descrip = rs.getString(12);
                int duration = Integer.parseInt(rs.getString(13));
                int num_view = Integer.parseInt(rs.getString(14));
                String author = rs.getString(15);
                String updateFilm = rs.getString(16);
                Film f = new Film(Filmid, FilmName1, FilmName2, convertString(status), convertString(director), convertString(actor), CateId, typeFilm, nationId, year, image, descrip, duration, num_view, convertString(author), updateFilm);
                data.add(f);
            }
        } catch (Exception e) {
            System.out.println("getListFilm was error:" + e.getMessage());
        }
        return data;
    }
    

}
