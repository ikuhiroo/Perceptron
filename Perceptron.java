public class Perceptron{
    //入力パターン
    final static double X[] = {1.2, 0.2, -0.2, -0.5, -1.0, -1.5};
    //正解ラベル
    final static int target[] = {1, 1, 1, -1, -1, -1};
    //学習率
    final static double eta = 1.2;
    //iter
    final static int iter = 100;
    //重みベクトル
    static double w[] = {-7, 2};
    //error
    static int error = 0;

    public static void main(String[] args){
        //初期化の確認
        String init_txt = String.format("w0=%.1f, w1=%.1f, eta=%.1f, iter=%d", w[0], w[1], eta, iter);
        System.out.println(init_txt);

        //epochを回す
        for(int epoch = 0; epoch < iter; epoch++){
            error = 0;
            update();
            if(error == 0){
                break;
            }
        }
    }

    //学習
    public static void update(){
        //バッチ処理
        for(int xi = 0; xi < X.length; xi++){
            //誤分類の確認
            double haserror = eta * (target[xi] - predict(xi));
            if(haserror != 0){
               error += 1;
            }
            //wの更新
            w[0] = w[0] + haserror;
            w[1] = w[1] + (haserror * X[xi]);
        }
        String result = String.format("誤分類数=%d, w0=%.1f, w1=%.1f", error, w[0], w[1]);
        System.out.println(result);
    }

    //クラス分類
    private static int predict(int i){
        //モデル出力値
        double pred = w[0] + (w[1] * X[i]);
        //predに基づくクラス分類
        if(pred >= 0){
           return 1;
        }else{
           return -1;
        }
    }
}
