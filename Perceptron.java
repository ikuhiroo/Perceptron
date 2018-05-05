public class Perceptron{
    //入力パターン
    final static double X[] = {1.2, 0.2, -0.2, -0.5, -1.0, -1.5};
    //正解ラベル
    final static int target[] = {1, 1, 1, 0, 0, 0};
    //学習率 @param
    final static double eta = 1.2;
    //学習繰り返し回数 @param
    final static int iter = 100;
    //重みベクトル[w0, w1] @param
    static double w[] = {-7, 2};
    //error
    static int error = 0;

    public static void main(String[] args){
        for(int epoch = 0; epoch < iter; epoch++){
            if(epoch==0){
                String hyparameter = String.format("hyparameter : eta=%.1f, w0=%.1f, w1=%.1f, iter=%d", eta, w[0], w[1], iter);
                String init_result = String.format("0epoch : 誤分類数=%d", getErrorCnt(X));
                System.out.println(hyparameter);
                System.out.println(init_result);
            }else{
                error = 0;
                train(epoch);
                if(error == 0){
                    break;
                }
            }
        }
    }
    // 1epoch当たりの誤分類数の取得
    private static int getErrorCnt(double X[]){
        for(int xi = 0; xi < X.length; xi++){
            //誤分類の確認
            double haserror = target[xi] - classify(xi);
            if(haserror != 0){
               error += 1;
            }
        }
        return error;
    }

    //学習
    private static void train(int epoch){
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
                String result = String.format("w0=%.1f, w1=%.1f", w[0], w[1]);
                System.out.println(result);
            }
        }
        String result = String.format("%depoch : 誤分類数=%d", epoch, error);
        System.out.println(result);
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
