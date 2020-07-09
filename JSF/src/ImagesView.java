import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

import com.sun.tools.javac.util.List;

@RequestScoped
public class ImagesView {
     
    private java.util.List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            images.add("nature" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return (List<String>) images;
    }
}