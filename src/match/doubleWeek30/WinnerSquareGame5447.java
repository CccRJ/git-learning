package match.doubleWeek30;

/**
 * @program: Java_Learning
 * @description: 5447. 石子游戏 IV
 * @author: ChaiRJ
 * @create: 2020-07-11 23:21
 **/
public class WinnerSquareGame5447 {
    public boolean winnerSquareGame(int n) {
        boolean[] isWin = new boolean[n+1];
        for (int i = 1;i <= n;i++){
            if(Math.sqrt(i) % 1 == 0)isWin[i] = true;
            else{
                int j = 1;
                while(i - j * j > 0){
                    //前面只要有F就能赢
                    if(!isWin[i - j * j]){
                        isWin[i]=true;
                        break;
                    }else j++;//前面全是T就输
                }
            }
        }
        return isWin[n];
    }
    public boolean winnerSquareGame2(int n){
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WinnerSquareGame5447().winnerSquareGame(7));
    }
}
