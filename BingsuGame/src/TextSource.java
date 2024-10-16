import java.util.*;

public class TextSource {
    private Vector<String> v = new Vector<String>();

    public TextSource() {
        v.add("초코빙수");
        v.add("눈꽃빙수");
        v.add("녹차빙수");
        v.add("인절미빙수");
        v.add("과일빙수");
        v.add("요거트빙수");
        v.add("팥빙수");
        v.add("맛있다!");
        v.add("멋지다!");
        v.add("복숭아");
        v.add("빙수야~");
        v.add("팥빙수야~");
        v.add("녹지마");
        v.add("사랑해");
        v.add("김민서의");
        v.add("최애빙수를");
        v.add("맞춰라");
        v.add("정답은");
        v.add("바로바로");
        v.add("인절미빙수!");
        v.add("주지혜의");
        v.add("최애빙수는");
        v.add("녹차빙수!");
        v.add("잊지마");
        v.add("얼음");
        v.add("체리");
        v.add("수박");
        v.add("망고");
        v.add("겨울");
        v.add("여름");
        v.add("연유");
    }

    public String get() {
        int index = (int) (Math.random() * v.size());
        return v.get(index);
    }

    public List<String> getAllWords() {
        return new ArrayList<>(v);
    }
}
