# Perceptron  

## 問題  
1Dに6個の学習標本がある．  
この学習標本を線形に分離するような分類器設計を行う．  
クラス1 : 1.2, 0.2, -0.2  
クラス2 : -0.5, -1.0, -1.5  

## パーセプトロンの学習規則  
### one-hot vectorの定義  
```
// 入力パターン
final static double X[] = {1.2, 0.2, -0.2, -0.5, -1.0, -1.5};
// 正解ラベル
final static int target[] = {1, 1, 1, 0, 0, 0};
```
### ハイパーパラメータの設定 
● 学習率  
● 学習繰り返し回数  
● 初期重みベクトル  

### 分類規則（classify）  
拡張特徴ベクトルと拡張重みベクトルの内積の値が0より大きか否かで，
モデルの出力値(classify(xi))を決定する．  
```
// モデル出力値  
double pred = w[0] + (w[1] * X[xi]);  
//predに基づくクラス分類
if(pred >= 0){
    return 1; 
}else{
    return 0; 
}
```    
### 損失関数の定義と学習方法  
```
// 誤分類数
double haserror = eta * (target[xi] - classify(xi));                
// wの更新
w[0] = w[0] + haserror;
w[1] = w[1] + (haserror * X[xi]);
````
    

   
