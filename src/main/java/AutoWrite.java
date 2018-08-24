import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AutoWrite {
  public static void main(String[] args) throws IOException {
    File file = new File("/Users/YiJia/Documents/MyGitHub/AlgoPractice/README.md");
    BufferedWriter bw = null;
    try {
      bw = new BufferedWriter(new FileWriter(file, true));
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("IO exception found");
    }

    String originalName = "LC218TheSkylineProblem";
    String className = "";
    className =
        originalName.replaceAll("(.)([A-Z])", "$1 $2").replaceAll("L C", "LC").replaceAll("(\\d+)",
            "$1.");

    System.out.println(className);


    String prefix = "./src/main/java/";

    bw.write("\n[" + className + "](" + prefix  + originalName + ".java),");
    bw.close();
  }
}
