



import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.PrintWriter;

import java.util.StringTokenizer;

 class sevenseg {

	

	public static void main(String[] args) {



		FastReader scn = new FastReader();

		int tc = scn.nextInt();



		while (tc-- > 0) {


			int n = scn.nextInt();

			int a[] = new int[n];

			int b[] = new int[n];

			for (int i = 0; i < n; i++) {

				a[i] = scn.nextInt();

				b[i] = scn.nextInt();

			}

			solve(n, a, b);

		}

		System.out.println(sb.toString());

	}





static StringBuilder sb=new StringBuilder();

	private static void solve(int n, int[] a, int[] b) {

		

//		int on[] = { 0, 2, 5, 5, 4, 5, 6, 3, 7, 6 };

		int code[] = { 63, 48, 109, 121, 114, 91, 95, 49, 127, 123 };

		int ans[] = new int[128];

		for (int i = 0; i < 128; i++) {

			boolean valid = true;

			for (int j = 0; j < n; j++) {



				int z = (code[a[j]] & i);

				int z1 = code[a[j]] ^ z;

				if (Integer.bitCount(z1) != b[j]) {

					valid = false;

					ans[i] = Integer.MIN_VALUE;

					break;

				}



			}

			if (valid)

				ans[i] = Integer.bitCount(i);

		}

		int min = Integer.MAX_VALUE;

		int max = Integer.MIN_VALUE;

		for (int val : ans) {

			if (val >= 0) {

				min = Math.min(min, val);

				max = Math.max(max, val);

			}

		}



		if (min != Integer.MAX_VALUE) { sb.append(min+" "+max+"\n");



		} else sb.append("invalid\n");
			out.println("invalid");




	static class FastReader {

		BufferedReader br;

		StringTokenizer st;



		public FastReader() {

			br = new BufferedReader(new InputStreamReader(System.in));

		}



		String next() {

			while (st == null || !st.hasMoreElements()) {

				try {

					st = new StringTokenizer(br.readLine());

				} catch (IOException e) {

					e.printStackTrace();

				}

			}

			return st.nextToken();

		}



		int nextInt() {

			return Integer.parseInt(next());

		}



		long nextLong() {

			return Long.parseLong(next());

		}



		double nextDouble() {

			return Double.parseDouble(next());

		}



		String nextLine() {

			String str = "";

			try {

				str = br.readLine();

			} catch (IOException e) {

				e.printStackTrace();

			}

			return str;

		}

	}



}

