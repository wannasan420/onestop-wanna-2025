package com.jdc.wanna.model;

public class Dictionary {

	private int capacity;
	private int size;
	private Entry[] entries;
	
	
	

	public Dictionary(int capacity) {
		super();
		this.capacity = capacity;
		this.entries = new Entry[capacity];
	}

	public int register(String question, String answer) {
		if (size < capacity) {
			int hash = hash(question);
			Entry entry = entries[hash];
 
			if (entry == null) {
				entries[hash] = new Entry(question, answer);
			} else {
				if (entry.question().equals(question)) {
					entries[hash] = new Entry(question, answer);
				}
				int index = (hash + 1) % capacity;
				while (true) {
					if (entries[index] == null) {
						entries[index] = new Entry(question, answer);
						break;
					}

					index = (index + 1) % capacity;

				}
			}
			return ++size;
		}
		return -1;
	}

	public String search(String question) {

		if (size > 0) {
			var hash = hash(question);
			var entry = entries[hash];

			if (null != entry) {
				if (entry.question().equals(question)) {
					return entry.answer();
				}

				var index = (hash + 1) % capacity;

				for (;;) {

					if (hash == index) {
						break;
					}

					var next = entries[index];
					if (next.question().equals(question)) {
						return next.answer();
					}

					index = (index + 1) % capacity;
				}
			}
		}

		return null;
	}

	public int hash(String question) {
		int hash = question.hashCode() % capacity;
		return hash < 0 ? hash * -1 : hash;
	}

	public static record Entry(String question, String answer) {
	}
}
