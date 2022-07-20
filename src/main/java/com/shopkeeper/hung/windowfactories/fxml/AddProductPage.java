package com.shopkeeper.hung.windowfactories.fxml;

import com.shopkeeper.lam.funtions.CategoryManager;
import com.shopkeeper.lam.funtions.PersonManager;
import com.shopkeeper.lam.funtions.ProductInfoManager;
import com.shopkeeper.lam.funtions.PublisherManager;
import com.shopkeeper.lam.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class AddProductPage extends Controller implements Initializable {
    @FXML
    AnchorPane ancestor, bookAnchorPane, musicAnchorPane, filmAnchorPane;
    @FXML
    TextField name,price, rating, left, pageNumber, timeMusic, timeFilm;
    @FXML
    TextArea award, description;
    @FXML
    ComboBox<String> type, publisherComboBox, categoryComboBox, musicianComboBox, actorsComboBox, directorComboBox
    ,authorsComboBox ;
    @FXML
    DatePicker releaseDate;
    @FXML
    ListView<String> musiciansList, actorsListView, authorsListView;
    private ProductInfo productInfo ;

    private final ObservableList<String> authorsName = FXCollections.observableArrayList();
    private final ObservableList<String> musicianName = FXCollections.observableArrayList();
    private final ObservableList<String> actorsName = FXCollections.observableArrayList();
    public boolean check(){

        var x = productInfo;
        return(x.getPublisher()!= null &&x.getTitle()!=null &&x.getReleaseDate()!=null
        &&x.getAward()!=null && x.getCategory()!=null);
    }
    public void getInfo() throws Exception {
        if(name.getText().equals("")
                || price.getText().equals("")
                || left.getText().equals("")
                || description.getText().equals("")
                || rating.getText().equals("")
                || award.getText().equals(""))
            return;
        var check = type.getValue();
        if(check == null) {
            return;
        }
        Category category = null;
        for(var x: CategoryManager.getManager().getAll()){
            if(x.getName().equals(categoryComboBox.getValue())){
                category= x;
                break;
            }
        }
        Publisher publisher = null;
        for(var x: PublisherManager.getManager().getAll()){
            if(x.getName().equals(publisherComboBox.getValue())){
                publisher = x;
                break;
            }
        }
        productInfo = new ProductInfo(name.getText(),description.getText(),category, releaseDate.getValue(),
                Integer.parseInt(price.getText()),publisher,
                Integer.parseInt(rating.getText()),new ArrayList<> (Arrays.asList(award.getText().split("\n"))));
    }

    public void setAddAuthorButton(){
        if(authorsComboBox.getValue()==null)
            return;
        authorsName.add(authorsComboBox.getValue());
    }

    public void setAddActorButton(){
        if(actorsComboBox.getValue()==null)
            return;
        actorsName.add(actorsComboBox.getValue());
    }

    public void setAddMusicianButton(){
        if(musicianComboBox.getValue()==null)
            return;
        musicianName.add(musicianComboBox.getValue());
    }
    public void removeAuthorButton(){
        if(authorsName.size()==0)
            return;
        authorsName.remove(authorsName.get(authorsName.size()-1));
    }

    public void removeActorButton(){
        if(actorsName.size()==0)
            return;
        actorsName.remove(actorsName.get(actorsName.size()-1));
    }

    public void removeMusicianButton(){
        if(musicianName.size()==0)
            return;
        musicianName.remove(musicianName.get(musicianName.size()-1));
    }

    public void setType(){
        var cur = type.getValue();
        if(cur==null)
            return;
        String temp= type.getValue().toLowerCase();
        switch(temp){
            case "book"-> bookAnchorPane.toFront();
            case "film"-> filmAnchorPane.toFront();
            case "music"-> musicAnchorPane.toFront();
            default -> throw new IllegalStateException("Unexpected value: " + temp);
        }
    }
    public void setDoneButton() throws Exception {
        getInfo();
        if(!check()) return;
        if(type.getValue()==null)
            return;
        String temp= type.getValue().toLowerCase();
        switch(temp){
            case "book"->{
                ArrayList<Person> authors = new ArrayList<>();
                var dbMusicians = PersonManager.getManager().getAll();
                for(var x: authorsName){
                    int index=0;
                    while(index<dbMusicians.size() && !dbMusicians.get(index).getName().equals(x))
                        index++;
                    if(index >=dbMusicians.size())
                        return;
                    authors.add(dbMusicians.get(index));
                }
                BookInfo res=  new BookInfo(productInfo.getTitle(), productInfo.getDescription(), productInfo.getCategory()
                        ,productInfo.getReleaseDate(),productInfo.getCurrentSalePrice(),productInfo.getPublisher(),
                        productInfo.getRating(),productInfo.getAward(),
                        authors,Integer.parseInt(pageNumber.getText()));
                res.setNumberOfProduct(productInfo.getNumberOfProduct());

                ProductInfoManager.getManager().add(res);
                ProductPage parent =(ProductPage) this.getParent();
                parent.reload();
//                parent.getShowedProducts().add(res);
//                parent.initShow(parent.getShowedProducts());


            }
            case "film"->{
                ArrayList<Person> actors = new ArrayList<>();
                var dbMusicians = PersonManager.getManager().getAll();
                Person director = new Person();
                for(var x: actorsName){
                    int index=0;
                    while(index<dbMusicians.size() && !dbMusicians.get(index).getName().equals(x))
                        index++;
                    if(index >=dbMusicians.size())
                        return;
                    actors.add(dbMusicians.get(index));
                }
                for(var x: dbMusicians)
                    if(x.getName().equals(directorComboBox.getValue()))
                        director = x;
                if(director.getName() ==null)
                    return;

                int mins =Integer.parseInt(timeFilm.getText());

                FilmInfo res=  new FilmInfo(productInfo.getTitle(), productInfo.getDescription(), productInfo.getCategory()
                        ,productInfo.getReleaseDate(),productInfo.getCurrentSalePrice(),productInfo.getPublisher(),
                        productInfo.getRating(),productInfo.getAward(),director,actors,
                        LocalTime.of(mins/60, mins%60)
                        );
                res.setNumberOfProduct(productInfo.getNumberOfProduct());
                ProductInfoManager.getManager().add(res);
                ProductPage parent =(ProductPage) this.getParent();
                parent.reload();
//                parent.getShowedProducts().add(res);
//                parent.initShow(parent.getShowedProducts());
            }
            case "music"->{
                ArrayList<Person> musicians = new ArrayList<>();
                var dbMusicians = PersonManager.getManager().getAll();
                for(var x: musicianName){
                    int index=0;
                    while(index<dbMusicians.size() && !dbMusicians.get(index).getName().equals(x))
                        index++;
                    if(index >=dbMusicians.size())
                        return;
                    musicians.add(dbMusicians.get(index));
                }
                int mins =Integer.parseInt(timeMusic.getText());

                MusicInfo res=  new MusicInfo(productInfo.getTitle(), productInfo.getDescription(), productInfo.getCategory()
                ,productInfo.getReleaseDate(),productInfo.getCurrentSalePrice(),productInfo.getPublisher(),
                        productInfo.getRating(),productInfo.getAward(),
                        musicians,LocalTime.of(mins/60, mins%60));
                res.setNumberOfProduct(productInfo.getNumberOfProduct());
                ProductInfoManager.getManager().add(res);
                ProductPage parent =(ProductPage) this.getParent();
                parent.reload();
//                parent.getShowedProducts().add(res);
//                parent.initShow(parent.getShowedProducts());

            }
            default -> throw new IllegalStateException("Unexpected value: " + temp);
        }

        System.out.println("finish add new productInfo");
        close();
    }

    ObservableList<String> typeString = FXCollections.observableArrayList("Book", "Music", "Film");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try{
            setRoot(this.ancestor);
            type.setItems(typeString);
            type.setStyle("-fx-font-size: 20");
            type.setStyle("-fx-font-family: 'Times New Roman'");

            var categories= CategoryManager.getManager().getAll();
            ObservableList<String> nameCategory = FXCollections.observableArrayList();
            for(var x: categories) nameCategory.add(x.getName());
            categoryComboBox.setItems(nameCategory);
            categoryComboBox.setStyle("-fx-font-size: 20");
            categoryComboBox.setStyle("-fx-font-family: 'Times New Roman'");

            ObservableList<String> namePublisher = FXCollections.observableArrayList();
            var publishers = PublisherManager.getManager().getAll();
            for(var x: publishers) namePublisher.add(x.getName());
            publisherComboBox.setItems(namePublisher);
            publisherComboBox.setStyle("-fx-font-size: 20");
            publisherComboBox.setStyle("-fx-font-family: 'Times New Roman'");

            ObservableList<String> nameMusician = FXCollections.observableArrayList();
            var musicians = PersonManager.getManager().getAll();
            for(var x: musicians) {
                if(x.getJob() == JobOfPerson.MUSICIAN || x.getJob() ==JobOfPerson.CEO || x.getJob() == JobOfPerson.SINGER)
                    nameMusician.add(x.getName());
            }
            musicianComboBox.setItems(nameMusician);
            musicianComboBox.setStyle("-fx-font-size: 20");
            musicianComboBox.setStyle("-fx-font-family: 'Times New Roman'");

            ObservableList<String> nameActors =FXCollections.observableArrayList();
            for(var x: musicians){
                if(x.getJob() == JobOfPerson.ACTOR  || x.getJob() ==JobOfPerson.CEO )
                    nameActors.add(x.getName());
            }
            actorsComboBox.setItems(nameActors);

            ObservableList<String> nameDirectors =FXCollections.observableArrayList();
            for(var x: musicians){
                if(x.getJob() == JobOfPerson.FILM_DIRECTOR  || x.getJob() ==JobOfPerson.CEO)
                    nameDirectors.add(x.getName());
            }
            directorComboBox.setItems(nameDirectors);

            ObservableList<String> nameAuthors =FXCollections.observableArrayList();
            for(var x: musicians){
                if(x.getJob() == JobOfPerson.MOTIVATIONAL_AUTHOR  || x.getJob() ==JobOfPerson.CEO || x.getJob()==JobOfPerson.WRITER || x.getJob() == JobOfPerson.POET)
                    nameAuthors.add(x.getName());
            }
            authorsComboBox.setItems(nameAuthors);

            actorsListView.setItems(actorsName);
            authorsListView.setItems(authorsName);
            musiciansList.setItems(musicianName);


        }catch (Exception e){
            System.out.println("bug init addProduct: " + e);
        }
    }
}
