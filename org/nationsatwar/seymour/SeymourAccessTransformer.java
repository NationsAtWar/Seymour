package org.nationsatwar.seymour;

import java.io.IOException;

import cpw.mods.fml.common.asm.transformers.AccessTransformer;

public class SeymourAccessTransformer extends AccessTransformer {

	public SeymourAccessTransformer() throws IOException {
		super("seymour_at.cfg");
	}

}
