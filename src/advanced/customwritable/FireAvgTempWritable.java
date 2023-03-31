package advanced.customwritable;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.checkerframework.checker.units.qual.Temperature;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class FireAvgTempWritable implements  WritableComparable<FireAvgTempWritable> {
    private float tempSum;
    private int n;

    public FireAvgTempWritable(float tempSum, int n) {
        this.tempSum = tempSum;
        this.n = n;
    }

    public float gettempSum() {
        return tempSum;
    }

    public void settempSum(float tempSum) {
        this.tempSum = tempSum;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public int compareTo(FireAvgTempWritable o) {
//        if (this.hashCode() < o.hashCode()) return -1;
//        else if (this.hashCode() > o.hashCode()) return 1;
//        return 0;
        return Integer.compare(this.hashCode(), o.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FireAvgTempWritable that = (FireAvgTempWritable) o;
        return Float.compare(that.tempSum, tempSum) == 0 && n == that.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tempSum, n);
    }

    // ESCREVER E LER NA MESMA ORDEM DE VARIAVEIS
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeFloat(this.tempSum);
        dataOutput.writeInt(this.n);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.tempSum = dataInput.readFloat();
        this.n = dataInput.readInt();
    }
}
