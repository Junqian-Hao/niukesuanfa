package basic_class_01;
import java.util.*;
public class Code_14_DogCatQueue {
	public static class Pet {
		private String type;

		public Pet(String type) {
			this.type = type;
		}
		
		public String getType() {
			return type;
		}
	}
	
	public static class Dog extends Pet{
		public Dog() {
			super("dog");
		}
	}
	
	public static class Cat extends Pet{
		public Cat() {
			super("cat");
		}
	}
	
	public static class PetEnter {
		private Pet pet;
		private int cont;
		
		public PetEnter(Pet pet , int cont) {
			this.pet = pet;
			this.cont = cont;
		}
		
		public Pet getPet() {
			return this.pet;
		}
		
		public int getCont() {
			return this.cont;
		}
		
		public String getPetType() {
			return this.pet.getType();
		}
	}
	
	private Queue<PetEnter> dogQueue = new LinkedList<PetEnter>();
	private Queue<PetEnter> catQueue = new LinkedList<PetEnter>();
	private int cont = 0;
	
	public void push(Pet pet) {
		String type = pet.getType();
		PetEnter petEnter = new PetEnter(pet , cont++);
		if("dog".equals(type)) {
			dogQueue.add(petEnter);
		}else if("cat".equals(type)) {
			catQueue.add(petEnter);
		}else {
		return;	
		}
	}
	
	public Pet pollAll() {
		if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
			if (this.dogQueue.peek().getCont() < this.catQueue.peek().getCont()) {
				return this.dogQueue.poll().getPet();
			} else {
				return this.catQueue.poll().getPet();
			}
		} else if (!this.dogQueue.isEmpty()) {
			return this.dogQueue.poll().getPet();
		} else if (!this.catQueue.isEmpty()) {
			return this.catQueue.poll().getPet();
		} else {
			throw new RuntimeException("err, queue is empty!");
		}
	}

	public Dog pollDog() {
		if (!this.isDogQueueEmpty()) {
			return (Dog) this.dogQueue.poll().getPet();
		} else {
			throw new RuntimeException("Dog queue is empty!");
		}
	}

	public Cat pollCat() {
		if (!this.isCatQueueEmpty()) {
			return (Cat) this.catQueue.poll().getPet();
		} else
			throw new RuntimeException("Cat queue is empty!");
	}
	
	public boolean isEmpty() {
		return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
	}

	public boolean isDogQueueEmpty() {
		return this.dogQueue.isEmpty();
	}

	public boolean isCatQueueEmpty() {
		return this.catQueue.isEmpty();
	}
	
	
	public static void main(String[] args) {
		 Code_14_DogCatQueue test = new  Code_14_DogCatQueue();

		Pet dog1 = new Dog();
		Pet cat1 = new Cat();
		Pet dog2 = new Dog();
		Pet cat2 = new Cat();
		Pet dog3 = new Dog();
		Pet cat3 = new Cat();

		test.push(dog1);
		test.push(cat1);
		test.push(dog2);
		test.push(cat2);
		test.push(dog3);
		test.push(cat3);

		test.push(dog1);
		test.push(cat1);
		test.push(dog2);
		test.push(cat2);
		test.push(dog3);
		test.push(cat3);

		test.push(dog1);
		test.push(cat1);
		test.push(dog2);
		test.push(cat2);
		test.push(dog3);
		test.push(cat3);
		while (!test.isDogQueueEmpty()) {
			System.out.println(test.pollDog().getType());
		}
		while (!test.isEmpty()) {
			System.out.println(test.pollAll().getType());
		}
	}
}
