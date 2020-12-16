package com.game.util;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Consts {
	
	public static final Map<KeyCode, Direction> keyToDirectionFrog1 =
		new HashMap<>() {
			private static final long serialVersionUID = 688766897487010503L;
			{
				put(KeyCode.W, Direction.UP);
				put(KeyCode.A, Direction.LEFT);
				put(KeyCode.S, Direction.DOWN);
				put(KeyCode.D, Direction.RIGHT);
			}
		};
		
	public static final Map<KeyCode, Direction> keyToDirectionFrog2 =
		new HashMap<>() {
			private static final long serialVersionUID = 7576406274457906742L;
			{
				put(KeyCode.I, Direction.UP);
				put(KeyCode.J, Direction.LEFT);
				put(KeyCode.K, Direction.DOWN);
				put(KeyCode.L, Direction.RIGHT);
			}
		};
		
	public static final Map<TextColor, String> colorToString =
			new HashMap<>() {
				private static final long serialVersionUID = 571861466604392697L;

				{
					put(TextColor.WHITE, "_white");
					put(TextColor.YELLOW, "_yellow");
					put(TextColor.RED, "_red");
					put(TextColor.MAGENTA, "_magenta");
					put(TextColor.BLUE, "_blue");
				}
			};
	
	public static final Map<String, String> charColorToFilePath =
		new HashMap<>() {
			private static final long serialVersionUID = -7980250545161547919L;
			{
				put("0_yellow", "file:src/assets/char/char_yellow_0.png");
				put("1_yellow", "file:src/assets/char/char_yellow_1.png");
				put("2_yellow", "file:src/assets/char/char_yellow_2.png");
				put("3_yellow", "file:src/assets/char/char_yellow_3.png");
				put("4_yellow", "file:src/assets/char/char_yellow_4.png");
				put("5_yellow", "file:src/assets/char/char_yellow_5.png");
				put("6_yellow", "file:src/assets/char/char_yellow_6.png");
				put("7_yellow", "file:src/assets/char/char_yellow_7.png");
				put("8_yellow", "file:src/assets/char/char_yellow_8.png");
				put("9_yellow", "file:src/assets/char/char_yellow_9.png");
				put("a_yellow", "file:src/assets/char/char_yellow_a.png");
				put("b_yellow", "file:src/assets/char/char_yellow_b.png");
				put("c_yellow", "file:src/assets/char/char_yellow_c.png");
				put("d_yellow", "file:src/assets/char/char_yellow_d.png");
				put("e_yellow", "file:src/assets/char/char_yellow_e.png");
				put("f_yellow", "file:src/assets/char/char_yellow_f.png");
				put("g_yellow", "file:src/assets/char/char_yellow_g.png");
				put("h_yellow", "file:src/assets/char/char_yellow_h.png");
				put("i_yellow", "file:src/assets/char/char_yellow_i.png");
				put("j_yellow", "file:src/assets/char/char_yellow_j.png");
				put("k_yellow", "file:src/assets/char/char_yellow_k.png");
				put("l_yellow", "file:src/assets/char/char_yellow_l.png");
				put("m_yellow", "file:src/assets/char/char_yellow_m.png");
				put("n_yellow", "file:src/assets/char/char_yellow_n.png");
				put("o_yellow", "file:src/assets/char/char_yellow_o.png");
				put("p_yellow", "file:src/assets/char/char_yellow_p.png");
				put("q_yellow", "file:src/assets/char/char_yellow_q.png");
				put("r_yellow", "file:src/assets/char/char_yellow_r.png");
				put("s_yellow", "file:src/assets/char/char_yellow_s.png");
				put("t_yellow", "file:src/assets/char/char_yellow_t.png");
				put("u_yellow", "file:src/assets/char/char_yellow_u.png");
				put("v_yellow", "file:src/assets/char/char_yellow_v.png");
				put("w_yellow", "file:src/assets/char/char_yellow_w.png");
				put("x_yellow", "file:src/assets/char/char_yellow_x.png");
				put("y_yellow", "file:src/assets/char/char_yellow_y.png");
				put("z_yellow", "file:src/assets/char/char_yellow_z.png");
				put("-_yellow", "file:src/assets/char/char_yellow_-.png");
			}
		};
}
