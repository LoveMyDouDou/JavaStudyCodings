package leetcode;

public class JudgeRouteCircle {

    public boolean judgeCircle(String moves) {
        int UD=0;
        int LR=0;
        for(int i=0;i<moves.length();++i){
            if(moves.charAt(i)=='L'){
                ++LR;
            }
            else if(moves.charAt(i)=='R'){
                --LR;
            }
            else if(moves.charAt(i)=='U'){
                ++UD;
            }
            else {
                --UD;
            }
        }
        if(UD==0&&LR==0){
            return true;
        }
        else {
            return false;
        }
    }

}
