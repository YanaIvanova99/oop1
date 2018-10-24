package sample;
import sample.*;
import java.net.URL;
import javafx.scene.control.TextArea;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller {
    @FXML
    private TextField subjectName;

    @FXML
    private TextField subjectHours;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane subjectPane, showPane;

    @FXML
    private Label cnsl;

    @FXML
    private TextArea showAll;

    @FXML
    void initialize() {
        //assert createSubject != null : "fx:id=\"createSubject\" was not injected: check your FXML file 'sample.fxml'.";
        assert subjectPane != null : "fx:id=\"subjectPane\" was not injected: check your FXML file 'sample.fxml'.";

    }

    ArrayList<Subject> subjects = new ArrayList<>();

    //открыть слой с заплнением
    public void openSubject(javafx.event.ActionEvent actionEvent) {
        hidePanes(false, true);
        cnsl.setText("Создание предмета");
    }


    //создание объекта предмет
    public void createSubject(javafx.event.ActionEvent actionEvent) {
        boolean error = true;
        int subjectHours1 = 0;

        if (error)
        {
            if (subjectName.getText().equals(""))
            {
                cnsl.setText("Некорректное название");
                error = false;
            }
        }
        if (error)
        {
            try
            {
                subjectHours1 = Integer.parseInt(subjectHours.getText());
            }
            catch (Exception e)
            {
                cnsl.setText("Некорректный ввод времени");
                error = false;
            }
        }
        if (error)
        {
            if (subjectHours1 > 300) {
                cnsl.setText("Неккоректный ввод времени");
                error = false;
            }
        }
        if (error)
        {
            for (int i=0; i<subjects.size(); i++)
            {
                 if (subjects.get(i).getName().equals(subjectName.getText()))
                 {
                     cnsl.setText("Уже есть такой предмет");
                     error=false;
                 }
            }
        }
        if (error)
        {
            subjects.add(new Subject(subjectName.getText(), subjectHours1));
            subjectHours.clear();
            subjectName.clear();
            cnsl.setText("Предмет успешно добавлен");
            hidePanes(true, true);
        }

    }

    public void hidePanes(boolean subject, boolean showInfo)
    {
        if (subject)
            this.subjectPane.setVisible(false);
        else
            this.subjectPane.setVisible(true);
        if (showInfo)
            this.showPane.setVisible(false);
        else
            this.showPane.setVisible(true);
    }

    @FXML
    void showInfo(ActionEvent event) {
        hidePanes(true, false);
        showAll.clear();
        for (int i = 0; i < subjects.size(); i++)
        {
            showAll.appendText("---------------------------------------" + "\n");
            showAll.appendText("Название предмета: " + subjects.get(i).getName() + "\n");
            showAll.appendText("Кол-во часов: " + subjects.get(i).getHours() + "\n");
            showAll.appendText("---------------------------------------" + "\n");
        }
    }


}
