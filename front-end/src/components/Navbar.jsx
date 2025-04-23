import { Link } from "react-router-dom"; // Caso esteja usando react-router-dom
import styles from "./Navbar.module.css"; // Importando o CSS Module

function Navbar() {
  return (
    <nav className={styles.navbar}>
      <ul className={styles.navbarList}>
        <li><Link to="/">Inicio</Link></li>
        <li><Link to="/about">Postagens</Link></li>
        <li><Link to="/contact">Publicar</Link></li>
      </ul>
    </nav>
  );
}

export default Navbar;
