package basic_class_01;

//之字形打印矩阵
public class Code_18_ZigZagPrintMatrix {
	/**
	 * 打印一条对角线上的数
	 * 
	 * @param m
	 *            二维矩阵
	 * @param tr
	 *            右上角点的横坐标
	 * @param tc
	 *            右上角点的纵坐标
	 * @param dr
	 *            左下角点的横坐标
	 * @param dc
	 *            左下角点的纵坐标
	 * @param f
	 *            打印方向 true右上到左下，false左下打到右上
	 */
	public static void printLevel(int[][] m, int tr, int tc, int dr, int dc, boolean f) {
		if (f) {
			while (tr != dr + 1) {
				System.out.print(m[tr++][tc--] + " ");
			}
		} else {
			while (dr != tr - 1) {
				System.out.print(m[dr--][dc++] + " ");
			}
		}
	}

	public static void printMatrixZigZag(int[][] matrix) {
		int ar = 0;
		int ac = 0;
		int br = 0;
		int bc = 0;

		int endr = matrix.length - 1;
		int endc = matrix[0].length - 1;

		boolean flag = false;

		while (ar != endr + 1) {
			printLevel(matrix, ar, ac, br, bc, flag);
			//a先右移动到最后一列后下移
			ar = ac == endc ? ar + 1 : ar;
			ac = ac == endc ? ac : ac + 1;
			//b下移到最后一行后右移(以下俩句顺序不能颠倒)
			bc = br == endr ? bc + 1 : bc;
			br = br == endr ? br : br + 1;
			//flag反向
			flag = !flag;
			
		}
		
		System.out.println();

	}
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}
}
