class CrammerMLR {
    public CrammerMLR() {
        calculate();
    }

    private double B0,B1,B2;
    private double[][] VectorData = {
        {41.9,29.1,251.3},
        {43.4,29.3,251.3},
        {43.9,29.5,248.3},
        {44.5,29.7,267.5},
        {47.3,29.9,273.0},
        {47.5,30.3,276.5},
        {47.9,30.5,270.3},
        {50.2,30.7,274.9},
        {52.8,30.8,285.0},
        {53.2,30.9,290.0},
        {56.7,31.5,297.0},
        {57.0,31.7,302.5},
        {63.5,31.9,304.5},
        {65.3,32.0,309.5},
        {71.1,32.1,321.7},
        {77.0,32.5,330.7},
        {77.8,32.9,349.0}
    };





    public void setVectorData(double[][] vectorData) {
        VectorData = vectorData;
        calculate();
    }


    public double getB0() {
        return B0;
    }

    public double getB1() {
        return B1;
    }

    public double getB2() {
        return B2;
    }

    private void calculate(){
        double sumX1 = 0,sumX2 = 0,sumY = 0,sumX1Y = 0,sumX2Y = 0,sumX1_2 = 0,sumX2_2 = 0,sumX1X2 = 0,n = VectorData.length;
        for (int i = 0 ; i < VectorData.length; i++){
            sumX1 += VectorData[i][0];
            sumX2 += VectorData[i][1];
            sumY += VectorData[i][2];
            sumX1Y += VectorData[i][0] * VectorData[i][2];
            sumX2Y += VectorData[i][1] * VectorData[i][2];
            sumX1_2 += VectorData[i][0] * VectorData[i][0];
            sumX2_2 += VectorData[i][1] * VectorData[i][1];
            sumX1X2 += VectorData[i][0] * VectorData[i][1];
        }
        B0 =  ((sumY*sumX1_2*sumX2_2+sumX1*sumX1X2*sumX2Y+sumX2*sumX1Y*sumX1X2) -
              (sumX2Y*sumX1_2*sumX2+sumX1X2*sumX1X2*sumY+sumX2_2*sumX1Y*sumX1)) /
              ((n*sumX1_2*sumX2_2+sumX1*sumX1X2*sumX2+sumX2*sumX1*sumX1X2) -
              (sumX2*sumX1_2*sumX2+sumX1X2*sumX1X2*n+sumX2_2*sumX1*sumX1));

        B1 = ((n*sumX1Y*sumX2_2+sumY*sumX1X2*sumX2+sumX2*sumX1*sumX2Y) -
             (sumX2*sumX1Y*sumX2+sumX2Y*sumX1X2*n+sumX2_2*sumX1*sumY)) /
             ((n*sumX1_2*sumX2_2+sumX1*sumX1X2*sumX2+sumX2*sumX1*sumX1X2) -
             (sumX2*sumX1_2*sumX2+sumX1X2*sumX1X2*n+sumX2_2*sumX1*sumX1));

        B2 = ((n*sumX1_2*sumX2Y+sumX1*sumX1Y*sumX2+sumY*sumX1*sumX1X2) -
             (sumX2*sumX1_2*sumY+sumX1X2*sumX1Y*n+sumX2Y*sumX1*sumX1)) /
             ((n*sumX1_2*sumX2_2+sumX1*sumX1X2*sumX2+sumX2*sumX1*sumX1X2) -
             (sumX2*sumX1_2*sumX2+sumX1X2*sumX1X2*n+sumX2_2*sumX1*sumX1));




    }
}
