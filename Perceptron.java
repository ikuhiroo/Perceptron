public class Perceptron{
    //入力パターン
    final static double X[] = {1.2, 0.2, -0.2, -0.5, -1.0, -1.5};
    //正解ラベル
    final static int target[] = {1, 1, 1, 0, 0, 0};
    //学習率
    final static double eta = 1.2;
    //学習繰り返し回数
    final static int iter = 100;
    //error
    static int error = 0;
    //重みベクトル[w0, w1]
    static double w[] = {-7, 2};

    public static void main(String[] args){
        //init
        for(int xi = 0; xi < X.length; xi++){
            int haserror = target[xi] - predict(xi);
            if(haserror != 0){
               error += 1;
            }
        }
        String hyparameter = String.format("hyparameter : eta=%.1f, iter=%d, w0=%.1f, w1=%.1f", eta, iter, w[0], w[1]);
        System.out.println(hyparameter);
        String init_result = String.format("0epoch : 誤分類数=%d", error);
        System.out.println(init_result);

        //epochを回す
        for(int epoch = 1; epoch < iter; epoch++){
            error = 0;
            update(epoch);
            if(error == 0){
                break;
            }
        }
    }

    //学習
    public static void update(int epoch){
        //バッチ処理
        for(int xi = 0; xi < X.length; xi++){
            //誤分類の確認
            double haserror = eta * (target[xi] - predict(xi));
            if(haserror != 0){
                //errorの更新
                error += 1;
                //wの更新
                w[0] = w[0] + haserror;
                w[1] = w[1] + (haserror * X[xi]);
                String result = String.format("w0=%.1f, w1=%.1f", w[0], w[1]);
                System.out.println(result);
            }
        }
        String result = String.format("%depoch : 誤分類数=%d", epoch, error);
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
           return 0;
        }
    }
}