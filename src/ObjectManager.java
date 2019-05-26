import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
 Rocketship rocket;
 ArrayList<Projectile> projectiles;
 ArrayList<Alien> aliens;
 Random random;
 
 ObjectManager(Rocketship rocket2){
	 rocket = new Rocketship(250,700,50,50);
	 projectiles = new ArrayList<Projectile>();
	 aliens = new ArrayList<Alien>();
	 random = new Random();
 }
 
 void addProjectile(Projectile e){
	 projectiles.add(e);
 }
 void addAlien() {
	 aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
 void update() {
	 for(int i=0;i<aliens.size();i++) {
		 aliens.get(i).update();
		 if(aliens.get(i).y>LeagueInvaders.HEIGHT || aliens.get(i).y<0 || aliens.get(i).x>LeagueInvaders.WIDTH || aliens.get(i).x<0) {
			 aliens.get(i).isActive = false;
		 }
	 }
	 for(int i=0;i<projectiles.size();i++) {
		 projectiles.get(i).update();
		 if(projectiles.get(i).y>LeagueInvaders.HEIGHT || projectiles.get(i).y<0 || projectiles.get(i).x>LeagueInvaders.WIDTH || projectiles.get(i).x<0) {
			 projectiles.get(i).isActive = false;
		 }
	 }
 }
 void draw(Graphics g) {
	 rocket.draw(g);
	 for(int i=0;i<aliens.size();i++) {
		 aliens.get(i).draw(g);
	 }
	 for(int i=0;i<projectiles.size();i++) {
		 projectiles.get(i).draw(g);
	 }
 }
 void purgeObjects() {
	 for(int i=0;i<aliens.size();i++) {
		 if(aliens.get(i).isActive == false) {
			 aliens.remove(i);
		 }
	 }
	 for(int i=0;i<projectiles.size();i++) {
		 if(projectiles.get(i).isActive == false) {
			 projectiles.remove(i);
		 }
	 }
 }
}
