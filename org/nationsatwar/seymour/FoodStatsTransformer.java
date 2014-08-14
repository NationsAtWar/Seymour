package org.nationsatwar.seymour;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodNode;

import org.objectweb.asm.ClassWriter;

import net.minecraft.launchwrapper.IClassTransformer;

public class FoodStatsTransformer implements IClassTransformer {
	//MD: ux/a (Luf;)V net/minecraft/util/FoodStats/onUpdate (Lnet/minecraft/entity/player/EntityPlayer;)V
	
	@Override
	public byte[] transform(String name, String transformedName, byte[] bytes) {
		try {
			if(name.equals("ux")) {
					System.out.println("********* INSIDE OBFUSCATED TRANSFORMER ABOUT TO PATCH: " + name);
					return patch("onUpdate", bytes, true);
			}
			if(name.equals("net.minecraft.util.FoodStats")) {
				System.out.println("********* INSIDE TRANSFORMER ABOUT TO PATCH: " + name);
				return patch("onUpdate", bytes, false);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}

	private byte[] patch(String realname, byte[] bytes, boolean b) throws IOException {
		String targetMethodName = "onUpdate";
		String className = "/org/nationsatwar/seymour/FoodStats.class";
		String desc = "(Lnet/minecraft/entity/player/EntityPlayer;)V";
		if(b) {
			targetMethodName = "a";
			className = "(Lorg/nationsatwar/seymour/FoodStats;)V";
			desc = "(Luf;)V";
		}
		
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(bytes);
		classReader.accept(classNode, 0);
		
		MethodNode node = null;
		for(MethodNode m : classNode.methods) {
			if(m.name.equals(targetMethodName) && m.desc.equals(desc)) {
				node = m;
				break;
			}
		}
		
		node.instructions = this.getMyNode(realname, className);
		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		classNode.accept(classWriter);
		
		return classWriter.toByteArray();
	}
	
	private InsnList getMyNode(String methodName, String className) throws IOException {
		java.io.InputStream in = FoodStatsTransformer.class.getResourceAsStream(className);
		byte[] newByte = IOUtils.toByteArray(in);
		
		ClassNode classNode = new ClassNode();
		ClassReader classReader = new ClassReader(newByte);
		classReader.accept(classNode, 0);
		
		MethodNode node = null;
		for(MethodNode m : classNode.methods) {
			if(m.name.equals(methodName)) {
				node = m;
				break;
			}
		}
		
		return node.instructions;
	}

}
