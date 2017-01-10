Object ob = new Object();
out.writeObject(ob);
out.writeObject(ob);
Each writeObject has to be matched by a readObject, so the code that reads the stream back will look something like this:

Object ob1 = in.readObject();
Object ob2 = in.readObject();