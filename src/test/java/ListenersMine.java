import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.*;


public class ListenersMine implements ITestListener {
    public ListenersMine() throws IOException {
    }

    File f1 = new File("TestResponses.txt");
    FileWriter fr = new FileWriter(f1,true);
    BufferedWriter writer = new BufferedWriter(fr);


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed - " + result.getName());
        try {
            FileWriter fr = new FileWriter(f1,true);
            BufferedWriter writer = new BufferedWriter(fr);
            writer.write("Test Failed - " + result.getName()+"\n");
            writer.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed - " + result.getName());
        try {
            FileWriter fr = new FileWriter(f1,true);
            BufferedWriter writer = new BufferedWriter(fr);
            writer.write("Test Passed - " + result.getName()+"\n");
            writer.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("This method runs when the Test ends");
        try {
            writer.write("Test End" +"\n");
            writer.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}