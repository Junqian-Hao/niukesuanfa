package basic_class_01;

//֮���δ�ӡ����
public class Code_18_ZigZagPrintMatrix {
	/**
	 * ��ӡһ���Խ����ϵ���
	 * 
	 * @param m
	 *            ��ά����
	 * @param tr
	 *            ���Ͻǵ�ĺ�����
	 * @param tc
	 *            ���Ͻǵ��������
	 * @param dr
	 *            ���½ǵ�ĺ�����
	 * @param dc
	 *            ���½ǵ��������
	 * @param f
	 *            ��ӡ���� true���ϵ����£�false���´�����
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
			//a�����ƶ������һ�к�����
			ar = ac == endc ? ar + 1 : ar;
			ac = ac == endc ? ac : ac + 1;
			//b���Ƶ����һ�к�����(��������˳���ܵߵ�)
			bc = br == endr ? bc + 1 : bc;
			br = br == endr ? br : br + 1;
			//flag����
			flag = !flag;
			
		}
		
		System.out.println();

	}
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}
}
