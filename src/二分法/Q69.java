package 二分法;

public class Q69 {
    /**
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 1)
            return 1;
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int muti = mid * mid;
            if (muti == x) {
                return mid;
            } else if (muti > x) {
                h = mid - 1;
            } else if (muti < x) {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 正确版本
     * @param x
     * @return
     */
    public int f(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            //这一步值得注意
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }
}
