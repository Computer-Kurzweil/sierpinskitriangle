package org.woehlke.computer.kurzweil.sierpinksitriangle.model;

import lombok.Getter;
import org.woehlke.computer.kurzweil.sierpinksitriangle.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.geometry.LatticeDimension;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.geometry.LatticePoint;
import org.woehlke.computer.kurzweil.sierpinksitriangle.model.sierpinksi.TriagleContainer;
import org.woehlke.computer.kurzweil.sierpinksitriangle.view.SierpinksiTriangleFrame;

import java.io.Serializable;

/**
 * Sierpiński triangle. A Fractal with self self-similarity.
 * (C) 2006 - 2022 Thomas Woehlke
 * @author Thomas Woehlke
 *
 * @see ComputerKurzweilProperties
 * @see SierpinksiTriangleFrame
 * @see TriagleContainer
 *
 * @see <a href="https://github.com/Computer-Kurzweil/sierpinskitriangle">Github Repository</a>
 * @see <a href="https://java.woehlke.org/sierpinskitriangle/">Maven Project Reports</a>
 *
 * Created by tw on 16.12.2019.
 */
@Getter
public class SierpinksiTriangleModel implements Serializable {

    static final long serialVersionUID = 242L;

    private volatile SierpinksiTriangleFrame tab;
    private volatile TriagleContainer triagleContainer;

    private final LatticeDimension worldDimensions;

    public SierpinksiTriangleModel(SierpinksiTriangleFrame tab) {
        this.tab = tab;
        ComputerKurzweilProperties config = tab.getConfig();
        int scale = config.getSierpinskitriangle().getView().getScale();
        int width = scale * config.getSierpinskitriangle().getView().getWidth();
        int height = scale * config.getSierpinskitriangle().getView().getHeight();
        this.worldDimensions = LatticeDimension.of(width,height);
        this.triagleContainer = new TriagleContainer(tab, this.worldDimensions);
    }

    public void start(){
        this.triagleContainer.start();
    }

    public synchronized void step() {
         this.triagleContainer.step();
    }

    public void click(LatticePoint c) {}
}
