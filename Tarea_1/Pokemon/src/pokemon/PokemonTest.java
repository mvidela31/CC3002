package pokemon;

import static org.junit.Assert.*;
import org.junit.Test;

public class PokemonTest {

	Fire firePokemon = new Fire("Charmander", 500, 30);
	Water waterPokemon = new Water("Squirtle", 500, 30);
	Grass grassPokemon = new Grass("Bulbasaur", 500, 30);
	Electric electricPokemon = new Electric("Pikachu", 500, 30);
	Ground groundPokemon = new Ground("Diglett", 500, 30);
	Psychic psychicPokemon = new Psychic("Abra", 500, 30);
	Fighting fightingPokemon = new Fighting("Machop", 500, 30);
	Normal normalPokemon = new Normal("Meowth", 500, 30);
	
	@Test
	public void constructorsTest() {
		assertEquals(0, firePokemon.getDamageReceived());
		Fire evolvedFirePokemon = new Fire("Charmeleon", 1500, 60, 10);
		assertEquals(10, evolvedFirePokemon.getDamageReceived());
		assertEquals(0, waterPokemon.getDamageReceived());
		Water evolvedWaterPokemon = new Water("Wartortle", 1500, 60, 10);
		assertEquals(10, evolvedWaterPokemon.getDamageReceived());
		assertEquals(0, grassPokemon.getDamageReceived());
		Grass evolvedGrassPokemon = new Grass("Ivysaur", 1500, 60, 10);
		assertEquals(10, evolvedGrassPokemon.getDamageReceived());
		assertEquals(0, electricPokemon.getDamageReceived());
		Electric evolvedElectricPokemon = new Electric("Raichu", 1500, 60, 10);
		assertEquals(10, evolvedElectricPokemon.getDamageReceived());
		assertEquals(0, groundPokemon.getDamageReceived());
		Ground evolvedGroundPokemon = new Ground("Dugtrio", 1500, 60, 10);
		assertEquals(10, evolvedGroundPokemon.getDamageReceived());
		assertEquals(0, psychicPokemon.getDamageReceived());
		Psychic evolvedPsychicPokemon = new Psychic("Kadabra", 1500, 60, 10);
		assertEquals(10, evolvedPsychicPokemon.getDamageReceived());
		assertEquals(0, fightingPokemon.getDamageReceived());
		Fighting evolvedFightingPokemon = new Fighting("Machoke", 1500, 60, 10);
		assertEquals(10, evolvedFightingPokemon.getDamageReceived());
		assertEquals(0, normalPokemon.getDamageReceived());
		Normal evolvedNormalPokemon = new Normal("Persian", 1500, 60, 10);
		assertEquals(10, evolvedNormalPokemon.getDamageReceived());
	}
	
	@Test
	public void pokemonGettersTest() {
		assertEquals("Charmander", firePokemon.getName());
		assertEquals(500, firePokemon.getHP());
		assertEquals(30, firePokemon.getDamageDone());
		assertEquals(0, firePokemon.getDamageReceived());
	}
	
	@Test
	public void pokemonSettersTest() {
		firePokemon.setName("Charmeleon");
		assertEquals("Charmeleon", firePokemon.getName());
		firePokemon.setHP(1500);
		assertEquals(1500, firePokemon.getHP());
		firePokemon.setDamageDone(60);
		assertEquals(60, firePokemon.getDamageDone());
		firePokemon.setDamageReceived(10);
		assertEquals(10, firePokemon.getDamageReceived());
	}
	
	@Test
	public void normalAttackTest() {
		normalPokemon.attack(firePokemon);
		assertEquals(30, firePokemon.getDamageReceived());
		normalPokemon.attack(waterPokemon);
		assertEquals(30, waterPokemon.getDamageReceived());
		normalPokemon.attack(grassPokemon);
		assertEquals(30, grassPokemon.getDamageReceived());
		normalPokemon.attack(electricPokemon);
		assertEquals(30, electricPokemon.getDamageReceived());
		psychicPokemon.attack(groundPokemon);
		assertEquals(30, groundPokemon.getDamageReceived());
		normalPokemon.attack(psychicPokemon);
		assertEquals(30, psychicPokemon.getDamageReceived());
		normalPokemon.attack(fightingPokemon);
		assertEquals(30, fightingPokemon.getDamageReceived());
		normalPokemon.attack(normalPokemon);
		assertEquals(30, normalPokemon.getDamageReceived());
	}
	
	@Test 
	public void nonEffectiveAttackTest() {
		firePokemon.attack(waterPokemon);
		assertEquals(10, waterPokemon.getDamageReceived());
		waterPokemon.attack(grassPokemon);
		assertEquals(10, grassPokemon.getDamageReceived());
		grassPokemon.attack(firePokemon);
		assertEquals(10, firePokemon.getDamageReceived());
		electricPokemon.attack(electricPokemon);
		assertEquals(10, electricPokemon.getDamageReceived());
		electricPokemon.attack(groundPokemon);
		assertEquals(10, groundPokemon.getDamageReceived());
		groundPokemon.attack(grassPokemon);
		assertEquals(20, grassPokemon.getDamageReceived());
		groundPokemon.attack(fightingPokemon);
		assertEquals(10, fightingPokemon.getDamageReceived());
		psychicPokemon.attack(normalPokemon);
		assertEquals(10, normalPokemon.getDamageReceived());
		normalPokemon.attack(groundPokemon);
		assertEquals(20, groundPokemon.getDamageReceived());
		normalPokemon.setDamageDone(20);
		normalPokemon.attack(groundPokemon);
		assertEquals(20, groundPokemon.getDamageReceived());	
	}
	
	@Test 
	public void superEffectiveAttackTest() {
		firePokemon.attack(grassPokemon);
		assertEquals(60, grassPokemon.getDamageReceived());
		waterPokemon.attack(firePokemon);
		assertEquals(60, firePokemon.getDamageReceived());
		waterPokemon.attack(groundPokemon);
		assertEquals(60, groundPokemon.getDamageReceived());
		grassPokemon.attack(waterPokemon);
		assertEquals(60, waterPokemon.getDamageReceived());
		grassPokemon.attack(groundPokemon);
		assertEquals(120, groundPokemon.getDamageReceived());
		electricPokemon.attack(waterPokemon);
		assertEquals(120, waterPokemon.getDamageReceived());
		groundPokemon.attack(firePokemon);
		assertEquals(120, firePokemon.getDamageReceived());
		groundPokemon.attack(electricPokemon);
		assertEquals(60, electricPokemon.getDamageReceived());
		psychicPokemon.attack(psychicPokemon);
		assertEquals(60, psychicPokemon.getDamageReceived());
		fightingPokemon.attack(normalPokemon);
		assertEquals(60, normalPokemon.getDamageReceived());
	}
	
	@Test
	public void isDefeatedTest() {
		Normal damagedPokemon = new Normal("damagedPokemon", 500, 30, 450);
		firePokemon.attack(damagedPokemon);
		assertFalse(damagedPokemon.isDefeated());
		firePokemon.attack(damagedPokemon);
		assertTrue(damagedPokemon.isDefeated());
		damagedPokemon.attack(firePokemon);
		assertEquals(0, firePokemon.getDamageReceived());
	}
}