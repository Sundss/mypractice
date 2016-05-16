package pefectShuffle1;

import java.util.Arrays;
import java.util.Collection;

public class PefectShuffle {
	public static void main(String[] arg) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		PefectShuffle ps = new PefectShuffle();
		// ps.pefect_shuffle1(a, a.length/2-1);
		ps.perfect_shuffle3(a, a.length / 2 - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println(a);
	}

	// 翻转字符串时间复杂度O(to - from)
	public void reverse(int[] a) {
		int t;
		int from = 0;
		int to = a.length - 1;
		for (; from < to; ++from, --to) {
			t = a[from];
			a[from] = a[to];
			a[to] = t;
		}

	}

	// 循环右移num位 时间复杂度O(n)
	public void right_rotate(int[] a, int num, int n) {
		// reverse(a, 1, n - num);
		// reverse(a, n - num + 1,n);
		// reverse(a, 1, n);
		int[] temp = Arrays.copyOfRange(a, 1, n - num);
		reverse(temp);
		// System.arraycopy(temp, 0, a, 1, n-num);
		System.arraycopy(temp, 0, a, 0, n - num);

		temp = Arrays.copyOfRange(a, n - num, n);
		reverse(temp);
		System.arraycopy(temp, 0, a, n - num, n);

		temp = Arrays.copyOfRange(a, 0, n);
		reverse(temp);
		System.arraycopy(temp, 0, a, 0, n);
	}

	public void cycle_leader(int[] a, int from, int mod) {
		int last = a[from], t, i;

		for (i = from * 2 % mod; i != from; i = i * 2 % mod) {
			t = a[i];
			a[i] = last;
			last = t;
		}
		a[from] = last;
	}

	// 时间O(n)，空间O(1)
	public void perfect_shuffle3(int[] a, int n) {
		int n2, m, i, k, t;
		for (; n > 1;) {
			// step 1
			n2 = n * 2;
			for (k = 0, m = 1; n2 / m >= 3; ++k, m *= 3)
				;
			m /= 2;
			// 2m = 3^k - 1 , 3^k <= 2n < 3^(k + 1)

			// step 2
			int[] temp1 = Arrays.copyOfRange(a, m, n);
			right_rotate(temp1, m, n);
			System.arraycopy(a, m, temp1, 0, n);

			// step 3
			for (i = 0, t = 1; i < k; ++i, t *= 3) {
				cycle_leader(a, t, m * 2 + 1);
			}

			// step 4
			// a += m * 2;
			int[] temp2 = Arrays.copyOfRange(a, m * 2, a.length);
			System.arraycopy(a, m * 2, temp2, 0, temp2.length);
			n -= m;

		}
		// n = 1
		t = a[1];
		a[1] = a[2];
		a[2] = t;
	}

	public void pefect_shuffle1(int[] a, int n) {
		int n2 = n * 2, i;
		int[] b = new int[a.length];
		for (i = 1; i <= n2; ++i) {
			b[(i * 2) % (n2 + 1)] = a[i];
		}
		for (i = 1; i <= n2; ++i) {
			a[i] = b[i];
		}
	}
}
