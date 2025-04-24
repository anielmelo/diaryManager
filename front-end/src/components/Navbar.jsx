import { Link } from "react-router-dom"; // Caso esteja usando react-router-dom
import styles from "./Navbar.module.css"; // Importando o CSS Module

function Navbar() {
  return (
    <nav className={styles.navbar}>
      <h2 className={styles.h2} >Seu diário digital!</h2>
    </nav>
  );
}

export default Navbar;
