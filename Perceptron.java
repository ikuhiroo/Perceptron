public class Perceptron{
    //入力パターン
    final static double X[] = {1.2, 0.2, -0.2, -0.5, -1.0, -1.5};
    //正解ラベル
    final static int target[] = {1, 1, 1, 0, 0, 0};
    //学習率 @param[1.2, 3.6, 2.0]
    final static double eta = 2.0;
    //学習繰り返し回数 @param
    final static int iter = 100;
    //重みベクトル[w0, w1] @param[{-7, 2}, {-7, 2}, {11, 5}]
    static double w[] = {11, 5};
    //error
    static int error = 0;

    public static void main(String[] args){
        for(int epoch = 0; epoch < iter; epoch++){
            if(epoch==0){
                System.out.println(String.format("hyparameter : eta=%.1f, iter=%d", eta, iter));
                System.out.println(String.format("%depoch : ", epoch));
                System.out.println(String.format("w0=%.1f, w1=%.1f", w[0], w[1]));
            }else{
                System.out.println(String.format("%depoch : ", epoch));
                train(epoch);
                if(error == 0){
                    System.out.println("誤分類なし");
                    break;
                }
            }
        }
    }

    //学習
    private static void train(int epoch){
        error = 0;
        //バッチ処理
        for(int xi = 0; xi < X.length; xi++){
            //誤分類(=wの更新量)の確認
            double haserror = eta * (target[xi] - classify(xi));
            if(haserror != 0){
                //errorの更新
                error += 1;
                //wの更新
                w[0] = w[0] + haserror;
                w[1] = w[1] + (haserror * X[xi]);
                System.out.println(String.format("w0=%.1f, w1=%.1f", w[0], w[1]));
            }
        }
    }

    //クラス分類
    private static int classify(int xi){
        //モデル出力値
        double pred = w[0] + (w[1] * X[xi]);
        //predに基づくクラス分類
        if(pred >= 0){
           return 1;
        }else{
           return 0;
        }
    }
}
