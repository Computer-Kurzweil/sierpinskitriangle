package org.woehlke.computer.kurzweil.sierpinksitriangle.model.geometry;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.sierpinksitriangle.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.sierpinksitriangle.view.SierpinksiTriangleFrame;

import java.io.Serializable;

/**
 * Sierpiński triangle. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see ComputerKurzweilProperties
 * @see SierpinksiTriangleFrame
 * @see LatticeDimension
 *
 * @see <a href="https://github.com/Computer-Kurzweil/sierpinskitriangle">Github Repository</a>
 * @see <a href="https://java.woehlke.org/sierpinskitriangle/">Maven Project Reports</a>
 */
@Log4j2
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LatticeRectangle implements Serializable {

    static final long serialVersionUID = 242L;

    private LatticePoint start;

    private LatticeDimension dimension;

    public static LatticeRectangle of(LatticePoint start, LatticeDimension dimension){
        LatticeRectangle lb = new LatticeRectangle(start, dimension);
        return lb;
    }

    public static LatticeRectangle of(int startX, int  startY, int width, int height){
        LatticePoint start = new LatticePoint(startX, startY);
        LatticeDimension dimension = new LatticeDimension(width, height);
        LatticeRectangle lb = new LatticeRectangle(start, dimension);
        return lb;
    }
}
