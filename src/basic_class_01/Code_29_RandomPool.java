package basic_class_01;
import java.util.*;
//�ܹ����ɾ�����ȸ��ʷ���һ��key
public class Code_29_RandomPool {
	public static class Pool<T>{
		private HashMap<T,Integer> keyIndexMap;
		private HashMap<Integer,T> indexKeyMap;
		private int size;
		
		public Pool() {
			keyIndexMap = new HashMap<T,Integer>();
			indexKeyMap = new HashMap<Integer,T>();
			size = 0;
		}
		
		public void insert(T key) {
			if(!keyIndexMap.containsKey(key)) {
				keyIndexMap.put(key, size);
				indexKeyMap.put(size++, key);
			}
		}
		
		public void delete(T key) {
			if(keyIndexMap.containsKey(key)) {
				int deleteIndex = keyIndexMap.get(key);//��ɾ����key������
				int lastIndex = size--;//���һ��ֵ������
				T lastkey = indexKeyMap.get(lastIndex);
				//�����һ��������Ӧ��ֵ���ǵ�Ҫɾ����λ��
				this.keyIndexMap.put(lastkey, deleteIndex);
				this.indexKeyMap.put(deleteIndex, lastkey);
				//ɾ�����һ��λ��
				this.keyIndexMap.remove(key);
				this.indexKeyMap.remove(lastkey);
			}
		}
		
		public T getRandom() {
			if(this.size < 1) {
				return null;
			}
			return indexKeyMap.get((int)(Math.random() * size));
		}
		
	}
	
	public static void main(String[] args) {
		Pool<String> pool = new Pool<String>();
		pool.insert("zuo");
		pool.insert("cheng");
		pool.insert("yun");
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println("_______________________________");
		pool.delete("yun");
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());

	}
}
