public class ShortWordFilter implements Filter {
    @Override
    public boolean accept (Object x){
        String f = (String) x;
        return f.length() < 5;
    }
}
